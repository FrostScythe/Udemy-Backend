package com.learning_management_service.Udemy_Lite.service;

import com.learning_management_service.Udemy_Lite.dto.CourseRequestDTO;
import com.learning_management_service.Udemy_Lite.dto.CourseResponseDTO;
import com.learning_management_service.Udemy_Lite.model.Course;
import com.learning_management_service.Udemy_Lite.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Convert Entity → ResponseDTO
    private CourseResponseDTO mapToResponseDTO(Course course) {
        CourseResponseDTO dto = new CourseResponseDTO();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setDescription(course.getDescription());
        dto.setPrice(course.getPrice());
        dto.setCountry(course.getCountry());
        dto.setCategory(course.getCategory());
        dto.setAuthorId(course.getAuthorId());
        dto.setRating(course.getRating());
        dto.setViewCount(course.getViewCount());
        return dto;
    }

    // Convert RequestDTO → Entity
    private Course mapToEntity(CourseRequestDTO dto) {
        Course course = new Course();
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setPrice(dto.getPrice());
        course.setCountry(dto.getCountry());
        course.setCategory(dto.getCategory());
        // Set default values for fields not in request
        course.setRating(0.0); // New courses start with 0 rating
        course.setViewCount(0L); // New courses start with 0 views
        // Temporary placeholder until authentication is implemented
        // Instead of hardcoded "default_author"
        String authorId = "author_" + System.currentTimeMillis();
// Or use proper author management
        course.setAuthorId(authorId); // TODO: Replace with authenticated user ID
        return course;
    }

    // Update existing entity with RequestDTO data
    private void updateEntityFromDTO(Course course, CourseRequestDTO dto) {
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setPrice(dto.getPrice());
        course.setCountry(dto.getCountry());
        course.setCategory(dto.getCategory());
        // Note: Don't update rating, viewCount, or authorId during updates
        // These should be managed separately
    }

    // Create
    public CourseResponseDTO createCourse(CourseRequestDTO courseRequestDTO) {
        Course course = mapToEntity(courseRequestDTO);
        // TODO: Set authorId from authenticated user context
        // course.setAuthorId(getCurrentUserId());

        Course savedCourse = courseRepository.save(course);
        return mapToResponseDTO(savedCourse);
    }

    // Get all
    public List<CourseResponseDTO> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    // Get by ID
    public Optional<CourseResponseDTO> getCourseById(Long id) {
        return courseRepository.findById(id).map(this::mapToResponseDTO);
    }

    // Update
    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO courseRequestDTO) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id " + id));

        updateEntityFromDTO(course, courseRequestDTO);
        Course updatedCourse = courseRepository.save(course);
        return mapToResponseDTO(updatedCourse);
    }

    // Delete
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    // Method to increment view count
    public void incrementViewCount(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id " + courseId));
        course.setViewCount(course.getViewCount() + 1);
        courseRepository.save(course);
    }

    // Method to update rating (would be called after rating calculation)
    public void updateCourseRating(Long courseId, Double newRating) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id " + courseId));
        course.setRating(newRating);
        courseRepository.save(course);
    }
}