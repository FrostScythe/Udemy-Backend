package com.learning_management_service.Udemy_Lite.controller;

import com.learning_management_service.Udemy_Lite.model.Course;
import com.learning_management_service.Udemy_Lite.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/udemy/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping("/register")
    public String saveCourse(@RequestBody Course courseRequest){
        return courseService.addCourse(courseRequest);
    }

    @GetMapping("/find/{id}")
    public Course findCourseById(@PathVariable int id){
        return courseService.getCourseById(id);
    }

    @GetMapping("/findAll")
    public List<Course> findAllCourse(){
        return courseService.getAllCourse();
    }

    @GetMapping("/count")
    public String countCourse(){
        return courseService.countCourse();
    }

    @PutMapping("/update/{id}")
    public String updateCourse(@PathVariable int id, @RequestBody Course newCourseRequest){
        return courseService.updateCourse(id, newCourseRequest);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourseById(@PathVariable int id){
        return courseService.deleteCourseById(id);
    }
}