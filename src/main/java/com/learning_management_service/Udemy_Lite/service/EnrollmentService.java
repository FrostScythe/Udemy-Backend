package com.learning_management_service.Udemy_Lite.service;

import com.learning_management_service.Udemy_Lite.dto.EnrollmentResponseDTO;
import com.learning_management_service.Udemy_Lite.model.Enrollment;
import com.learning_management_service.Udemy_Lite.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    // Convert Entity → ResponseDTO
    private EnrollmentResponseDTO mapToResponseDTO(Enrollment enrollment){
        EnrollmentResponseDTO dto = new EnrollmentResponseDTO();
        return dto;
    }
}
