package org.icet.service.impl;

import lombok.RequiredArgsConstructor;
import org.icet.dto.User;
import org.icet.entity.UserEntity;
import org.icet.entity.enums.UserType;
import org.icet.repository.UserRepository;
import org.icet.service.FileService;
import org.icet.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final FileService fileService;
    private final ModelMapper mapper;

    @Value("${project.profile}")
    private String path;

    @Value("${base.url}")
    private String baseURL;

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(userEntity -> {
            users.add(mapper.map(userEntity,User.class));
        } );
        return users;
    }

    @Override
    public List<User> getAllStudents() {
        List<User> students = new ArrayList<>();
        getAllUsers().forEach(user -> {
            if (user.getUserType().equals(UserType.STUDENT)){
                students.add(user);
            }
        });
        return students;
    }

    @Override
    public List<User> getAllTeachers() {
        List<User> teachers = new ArrayList<>();
        getAllUsers().forEach(user -> {
            if (user.getUserType().equals(UserType.TEACHER)){
                teachers.add(user);
            }
        });
        return teachers;
    }

    @Override
    public List<User> getAllAdmin() {
        List<User> admins = new ArrayList<>();
        getAllUsers().forEach(user -> {
            if (user.getUserType().equals(UserType.ADMIN)){
                admins.add(user);
            }
        });
        return admins;
    }

    @Override
    public User getStudentById(Long userId) {
//        getAllStudents().forEach(student-> {
//            if (student.getUserId().equals(userId)){
//                return student;
//            }
//        });
        return getAllStudents().stream()
                .filter(student -> student.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User getTeacherById(Long userId) {
        return getAllTeachers().stream()
                .filter(teacher -> teacher.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User getAdminById(Long userId) {
        return getAllAdmin().stream()
                .filter(admin -> admin.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Integer getAllStudentsCount() {
        return getAllStudents() != null ? getAllStudents().size() : 0;
    }

    @Override
    public Integer getAllTeachersCount() {
        return getAllTeachers() != null ? getAllTeachers().size() : 0;
    }

    @Override
    public Integer getAllAdminsCount() {
        return getAllAdmin() != null ? getAllAdmin().size() : 0;
    }

//    @Override
//    public List<User> getStudentByUserName(String userName) {
//        return List.of();
//    }
//
//    @Override
//    public List<User> getTeacherByUserName(String userName) {
//        return List.of();
//    }
//
//    @Override
//    public List<User> getAdminByUserName(String userName) {
//        return List.of();
//    }

    @Override
    public User getStudentByEmail(String email) {
        return getAllStudents().stream()
                .filter(student -> student.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User getTeacherByEmail(String email) {
        return getAllTeachers().stream()
                .filter(teacher -> teacher.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User getAdminByEmail(String email) {
       return getAllAdmin().stream()
                .filter(admin->admin.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User setUser(User user, MultipartFile file) throws IOException {
        //youtube eken balan kare
        //1.upload the file
        String uploadFileName = fileService.uploadFile(path, file);

        //2.generate the profilePictureLink
        String profilePictureLink = baseURL + "/file/" +uploadFileName;

        //3.set the value of field 'profile' as filename and 'URL'
        user.setProfilePicture(uploadFileName);
        user.setProfilePictureLink(profilePictureLink);

        //4.save the userEntity object and return it
        System.out.println(mapper.map(user,UserEntity.class));
        UserEntity save = userRepository.save(mapper.map(user, UserEntity.class));
//
        return mapper.map(save,User.class);
//        return user;
    }

    @Override
    public User updateUser(User user, MultipartFile file) throws IOException {
        //youtube eken balan kare
        //1.upload the file
        String uploadFileName = fileService.uploadFile(path, file);

        //2.generate the profilePictureLink
        String profilePictureLink = baseURL + "/file/" +uploadFileName;

        //3.set the value of field 'profile' as filename and 'URL'
        user.setProfilePicture(uploadFileName);
        user.setProfilePictureLink(profilePictureLink);

        //4.save the userEntity object and return it
        return mapper.map(userRepository.save(mapper.map(user, UserEntity.class)),User.class);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
