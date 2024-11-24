package org.icet.service.impl;

import lombok.RequiredArgsConstructor;
import org.icet.dto.Course;
import org.icet.entity.CourseEntity;
import org.icet.repository.CourseRepository;
import org.icet.service.CourseService;
import org.icet.service.ProfileFileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final ModelMapper mapper;
    private final ProfileFileService fileService;

    @Value("${project.thumbnail}")
    private String path;

    @Value("${base.url}")
    private String baseURL;

    @Override
    public List<Course> getAllCourses() {
        List<Course> allCourses = new ArrayList<>();
        courseRepository.findAll().forEach(course -> allCourses.add(mapper.map(course,Course.class)));
        return allCourses;
    }

    @Override
    public List<Course> getCoursesByTitle(String courseTitle) {
        List<Course> courseList = new ArrayList<>();
        getAllCourses().forEach(course -> courseList.add(mapper.map(course,Course.class)));

        return courseList;
    }

    @Override
    public Course getCourseById(Long courseId) {
       return getAllCourses().stream()
                .filter(course -> course.getCourseId().equals(courseId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Course createCourse(Course course, MultipartFile file) throws IOException {

        //youtube eken balan kare
        //1.upload the file
        String uploadFileName = fileService.uploadFile(path, file);

        //2.generate the thumbnailpath
        String thumbnailPath = baseURL +"/file/getThumbnail/" +uploadFileName;

        //3.set the value of field 'profile' as filename and 'URL'
        course.setThumbnail(uploadFileName);
        course.setThumbnailPath(thumbnailPath);

        //4.save the userEntity object and return it
        CourseEntity save = courseRepository.save(mapper.map(course, CourseEntity.class));
        return mapper.map(save, Course.class);
    }

    @Override
    public Course updateCourse(Long courseId ,Course course, MultipartFile file) throws IOException {
        CourseEntity courseEntity = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found with id = " + courseId));

        String uploadFileName = courseEntity.getThumbnail();

        if (file != null){
            Files.deleteIfExists(Paths.get(path+File.separator+uploadFileName));
            uploadFileName = fileService.uploadFile( path, file);
        }
        //youtube eken balan kare
        //1.upload the file

        //2.generate the thumbnailpath
        String thumbnailPath = baseURL +"/file/getThumbnail/" +uploadFileName;

        //3.set the value of field 'profile' as filename and 'URL'
        course.setThumbnail(uploadFileName);
        course.setThumbnailPath(thumbnailPath);

        //4.save the userEntity object and return it
        CourseEntity save = courseRepository.save(mapper.map(course, CourseEntity.class));
        return mapper.map(save, Course.class);
    }

    @Override
    public void deleteCourse(Long courseId) throws IOException {
        CourseEntity courseEntity = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id = " + courseId));

        Files.deleteIfExists(Paths.get(path + File.separator + courseEntity.getThumbnail()));

        courseRepository.delete(courseEntity);

    }

    @Override
    public List<Course> getMyCourses(List<Long> courseIds) {
//        List<Long> courseList = new ArrayList<>(Arrays.asList(courseIds));

        List<Course> courseDto = new ArrayList<>();

        courseRepository.findAllById(courseIds).forEach(entity -> {
            courseDto.add(mapper.map(entity,Course.class));
        } );
        return courseDto;

    }
}
