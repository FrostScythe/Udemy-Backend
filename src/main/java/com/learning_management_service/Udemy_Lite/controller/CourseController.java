package com.learning_management_service.Udemy_Lite.controller;

import com.learning_management_service.Udemy_Lite.model.Course;
import com.learning_management_service.Udemy_Lite.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/udemy/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping("/register")
    public String saveCourse(@RequestBody Course courseRequest){
        String response =courseService.addCourse(courseRequest);
        return response;
    }
}
