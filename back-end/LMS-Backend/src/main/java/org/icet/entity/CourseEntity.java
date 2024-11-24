package org.icet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(nullable = false)
    private String courseTitle;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double courseFee;

    @Column(nullable = false)
    private Integer duration;

    @Column(nullable = false)
    private String teacherId;

    @Column(nullable = false)
    private String thumbnail;

    @Column(nullable = false)
    private String thumbnailPath;

    @Column(nullable = false)
    private String zoomLink;

//    @NotEmpty(message = "Record list cannot be empty")
    @ElementCollection
    private List<String> recordList;

}