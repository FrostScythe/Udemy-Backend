package com.learning_management_service.Udemy_Lite.dto;

import java.time.LocalDateTime;

public class EnrollmentResponseDTO {
    Long enrollmentId;
    Long userId;
    String userName;
    Long courseId;
    String courseTitle;
    LocalDateTime enrollmentDate;
}