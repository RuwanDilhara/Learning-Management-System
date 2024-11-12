package org.icet.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentID;
    private String fullName;
    private String userName;
    private String email;
    private String phoneNumber;
    private LocalDate dOB;
    private String address;
    private String grade;

    @JsonIgnore
    private String password;


    //private List<Course> coursesEnrolled;
}