package org.icet.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.icet.dto.Course;
import org.icet.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("api/v1/course/")
public class CourseController {
    private final CourseService courseService;
    private final ObjectMapper mapper;

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourses(){
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/getCourseByTitle/{courseTitle}")
    public ResponseEntity<List<Course>> getCoursesByTitle(@PathVariable String courseTitle){
        return ResponseEntity.ok(courseService.getCoursesByTitle(courseTitle));
    }

    @GetMapping("/getCourseById/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long courseId) {
        return ResponseEntity.ok(courseService.getCourseById(courseId));
    }

    @PostMapping("/set-course")
    public ResponseEntity<Course> setCourse(@RequestPart MultipartFile file
            ,@RequestPart String course) throws IOException {

        Course courseDto = convertToCourse(course);
        return new ResponseEntity<>(courseService.createCourse(courseDto,file), HttpStatus.CREATED);
    }

    @PutMapping("updateById/{courseId}")
    public ResponseEntity<Course> setUpdateCourse(@PathVariable Long courseId , @RequestPart MultipartFile file
            ,@RequestPart String course) throws IOException {

        Course courseDto = convertToCourse(course);
        return new ResponseEntity<>(courseService.createCourse(courseDto,file), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteById/{courseId}")
    public ResponseEntity<String> deleteCourseById(@PathVariable Long courseId) throws IOException {
        try {
            courseService.deleteCourse(courseId);
            return ResponseEntity.ok("User with ID " + courseId + " deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete user with ID " + courseId + ". Error: " + e.getMessage());
        }
    }

    private Course convertToCourse(String course) throws JsonProcessingException {
        return mapper.readValue(course, Course.class);
    }
}
