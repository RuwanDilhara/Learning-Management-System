package org.icet.service;

import org.icet.dto.Course;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    List<Course> getCoursesByTitle(String courseTitle);
    Course getCourseById(Long courseId);

    Course createCourse(Course course , MultipartFile file) throws IOException;
    Course updateCourse(Long courseId , Course course , MultipartFile file) throws IOException;

    void deleteCourse(Long courseId) throws IOException;

    List<Course> getMyCourses(List<Long> courseId );

}
