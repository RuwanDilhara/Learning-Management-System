package org.icet.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.icet.dto.Course;
import org.icet.dto.User;
import org.icet.service.CourseService;
import org.icet.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final CourseService courseService;
    private final ObjectMapper objectMapper;

    @PostMapping("/set-user")
    public ResponseEntity<User> setUser(@RequestPart MultipartFile file,
                                        @RequestPart String user) throws IOException {
        User userDto = convertToUser(user);
        return new ResponseEntity<>(userService.setUser(userDto, file), HttpStatus.CREATED);
    }

    private User convertToUser(String userJson) throws JsonProcessingException {
        return objectMapper.readValue(userJson, User.class);
    }

    @PutMapping("/update-user/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId ,@RequestPart MultipartFile file,
                                        @RequestPart String user) throws IOException {
        User userDto = convertToUser(user);
        return new ResponseEntity<>(userService.updateUser(userId,userDto, file), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("allStudent")
    public ResponseEntity<List<User>> getAllStudents(){
        return ResponseEntity.ok(userService.getAllStudents());
    }

    @GetMapping("/allTeacher")
    public ResponseEntity<List<User>> getAllTeachers(){
        return ResponseEntity.ok(userService.getAllTeachers());
    }

    @GetMapping("/allAdmin")
    public ResponseEntity<List<User>> getAllAdmin(){
        return ResponseEntity.ok(userService.getAllAdmin());
    }

    @GetMapping("/studentById/{userId}")
    public ResponseEntity<User> getStudentById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getStudentById(userId));
    }

    @GetMapping("/teacherById/{userId}")
    public ResponseEntity<User> getTeacherById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getTeacherById(userId));
    }

    @GetMapping("/adminById/{userId}")
    public ResponseEntity<User> getAdminById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getAdminById(userId));
    }

    @GetMapping("/allStudentCount")
    public ResponseEntity<Integer> getAllStudentsCount(){
        return ResponseEntity.ok(userService.getAllStudentsCount());
    }

    @GetMapping("/allTeacherCount")
    public ResponseEntity<Integer> getAllTeachersCount(){
        return ResponseEntity.ok(userService.getAllTeachersCount());
    }

    @GetMapping("/allAdminCount")
    public ResponseEntity<Integer> getAllAdminsCount(){
        return ResponseEntity.ok(userService.getAllAdminsCount());
    }

    @GetMapping("/studentByEmail/{email}")
    public ResponseEntity<User> getStudentByEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.getStudentByEmail(email));
    }

    @GetMapping("/teacherByEmail/{email}")
    public ResponseEntity<User> getTeacherByEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.getTeacherByEmail(email));
    }

    @GetMapping("/adminByEmail/{email}")
    public ResponseEntity<User> getAdminByEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.getAdminByEmail(email));
    }

    @DeleteMapping("/deleteById/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long userId){
        try {
            userService.deleteUser(userId);
            return ResponseEntity.ok("User with ID " + userId + " deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete user with ID " + userId + ". Error: " + e.getMessage());
        }
    }

    @GetMapping("userById/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

    @GetMapping("/myCourses/{userId}")
    public List<Course> getMyCourse(@PathVariable Long userId){
        User user = getUserById(userId);
        List<Long> courseIds = new ArrayList<>();
        user.getEnrolledCourses().forEach(entity -> {
            courseIds.add(entity.getCourseId());
        });

        return courseService.getMyCourses(courseIds);
    }
 }
