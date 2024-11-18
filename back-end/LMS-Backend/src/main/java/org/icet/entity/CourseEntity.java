package org.icet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Course")
public class CourseEntity {
    @Id
    private Long courseId;

    @NotBlank(message = "Course title is mandatory")
    private String courseTitle;

    @NotBlank(message = "Course description is mandatory")
    private String description;

    @NotBlank(message = "Course courseFee is mandatory")
    private Double courseFee;

    @NotBlank(message = "Course duration is mandatory")
    private String duration;

    @NotBlank(message = "Course teacherName is mandatory")
    private String teacherName;

    @NotBlank(message = "Course thumbnailPath is mandatory")
    private String thumbnailPath;

//    private List<UserEntity> enrolledUserList;
}
