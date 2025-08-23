package com.learning_management_service.Udemy_Lite.controller;

import com.learning_management_service.Udemy_Lite.dto.CourseRequestDTO;
import com.learning_management_service.Udemy_Lite.dto.CourseResponseDTO;
import com.learning_management_service.Udemy_Lite.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/udemy/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Create
    @PostMapping("/create")
    public ResponseEntity<CourseResponseDTO> createCourse(@Valid @RequestBody CourseRequestDTO courseRequestDTO) {
        try {
            CourseResponseDTO createdCourse = courseService.createCourse(courseRequestDTO);
            return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Read all
    @GetMapping("/findAll")
    public ResponseEntity<List<CourseResponseDTO>> getAllCourses() {
        try {
            List<CourseResponseDTO> courses = courseService.getAllCourses();
            if (courses.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(courses, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Read one
    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> getCourseById(@PathVariable Long id) {
        try {
            return courseService.getCourseById(id)
                    .map(course -> {
                        // Increment view count when course is accessed
                        courseService.incrementViewCount(id);
                        return new ResponseEntity<>(course, HttpStatus.OK);
                    })
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> updateCourse(@PathVariable Long id,
                                                          @Valid @RequestBody CourseRequestDTO courseRequestDTO) {
        try {
            CourseResponseDTO updatedCourse = courseService.updateCourse(id, courseRequestDTO);
            return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long id) {
        try {
            courseService.deleteCourse(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint to manually increment view count (if needed separately)
    @PatchMapping("/{id}/view")
    public ResponseEntity<HttpStatus> incrementViewCount(@PathVariable Long id) {
        try {
            courseService.incrementViewCount(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}