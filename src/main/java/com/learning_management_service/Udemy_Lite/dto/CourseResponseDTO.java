package com.learning_management_service.Udemy_Lite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String country;
    private String category;
    private String authorId;
    private Double rating;
    private Long viewCount;
}
