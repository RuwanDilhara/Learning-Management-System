package org.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.icet.entity.CourseEntity;
import org.icet.entity.enums.UserType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Long userId;

    private String firstName;

    private String lastName;

    private String userName;

    private UserType userType;

    private String email;

    private String password;

    private Integer age;

    private LocalDate dateOfBirth;

    private String profilePicture;

    private String profilePictureLink;

    private List<CourseEntity> enrolledCourses;

}
