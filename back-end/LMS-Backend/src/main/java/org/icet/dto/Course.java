package org.icet.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.icet.entity.UserEntity;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Course {

    private Long courseId;
    private String courseTitle;
    private String description;
    private Double courseFee;
    private Integer duration;
    private String teacherId;
    private String thumbnail;
    private String thumbnailPath;
    private String zoomLink;
    private List<String> recordList;

}