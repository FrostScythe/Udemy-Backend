package com.learning_management_service.Udemy_Lite.service;

import com.learning_management_service.Udemy_Lite.model.Course;
import com.learning_management_service.Udemy_Lite.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public String addCourse(Course courseRequest){
        courseRepository.save(courseRequest);
        return "Course saved successfully !!";
    }

    public Course getCourseById(int id){
        Optional<Course> courseOptional = courseRepository.findById(id);
        if(courseOptional.isPresent()){
            return courseOptional.get();
        } else {
            return null;
        }
    }

    public String updateCourse(int id, Course newCourseRequest){
        Course existingCourse = getCourseById(id);
        if(existingCourse != null){
            newCourseRequest.setId(id); // Set the ID explicitly
            courseRepository.save(newCourseRequest);
            return "Course updated successfully";
        } else {
            return "Course not found, hence cannot be updated";
        }
    }

    public String deleteCourseById(int id){
        // Check if course exists before deleting
        if(courseRepository.existsById(id)){
            courseRepository.deleteById(id);
            return "Course with id: " + id + " got deleted successfully!";
        } else {
            return "Course with id: " + id + " not found, cannot delete";
        }
    }

    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }

    public String countCourse(){
        long totalCount = courseRepository.count();
        return "Total courses present are: " + totalCount;
    }
}