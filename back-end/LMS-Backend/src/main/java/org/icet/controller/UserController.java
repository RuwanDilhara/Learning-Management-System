package org.icet.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.icet.dto.User;
import org.icet.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ObjectMapper objectMapper;  // Use ObjectMapper for JSON conversion

    @PostMapping("/set-user")
    public ResponseEntity<User> setUser(@RequestPart MultipartFile file,
                                        @RequestPart String user) throws IOException {
        User userDto = convertToUser(user);
        return new ResponseEntity<>(userService.setUser(userDto, file), HttpStatus.CREATED);
    }

    private User convertToUser(String userJson) throws JsonProcessingException {
        return objectMapper.readValue(userJson, User.class);  // Deserialize JSON to User object
    }

    @PutMapping("/update-user")
    public ResponseEntity<User> updateUser(@RequestPart MultipartFile file,
                                        @RequestPart String user) throws IOException {
        User userDto = convertToUser(user);
        return new ResponseEntity<>(userService.updateUser(userDto, file), HttpStatus.CREATED);
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

    @GetMapping("/student/{userId}")
    public ResponseEntity<User> getStudentById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getStudentById(userId));
    }

    @GetMapping("/teacher/{userId}")
    public ResponseEntity<User> getTeacherById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getTeacherById(userId));
    }

    @GetMapping("/admin/{userId}")
    public ResponseEntity<User> getAdminById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getTeacherById(userId));
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

    @GetMapping("/student/{email}")
    public ResponseEntity<User> getStudentByEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.getStudentByEmail(email));
    }

    @GetMapping("/teacher/{email}")
    public ResponseEntity<User> getTeacherByEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.getTeacherByEmail(email));
    }

    @GetMapping("/admin/{email}")
    public ResponseEntity<User> getAdminByEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.getAdminByEmail(email));
    }
 }
