package org.icet.service;

import org.icet.dto.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Service
public interface UserService {
    List<User> getAllUsers();
    List<User>getAllStudents();
    List<User>getAllTeachers();
    List<User>getAllAdmin();

    User getUserById(Long userId);

    User getStudentById(Long userId);
    User getTeacherById(Long userId);
    User getAdminById(Long userId);

//    List<User> getStudentByUserName(String userName);
//    List<User> getTeacherByUserName(String userName);
//    List<User> getAdminByUserName(String userName);

    Integer getAllStudentsCount();
    Integer getAllTeachersCount();
    Integer getAllAdminsCount();

    User getStudentByEmail(String email);
    User getTeacherByEmail(String email);
    User getAdminByEmail(String email);

    User setUser(User user,MultipartFile file) throws IOException;
    User updateUser(Long userId ,User user,MultipartFile file) throws IOException;

    void deleteUser(Long userId) throws IOException;


}