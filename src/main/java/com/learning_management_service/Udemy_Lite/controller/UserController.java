package com.learning_management_service.Udemy_Lite.controller;

import com.learning_management_service.Udemy_Lite.model.User;
import com.learning_management_service.Udemy_Lite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/udemy/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public String saveUser(@RequestBody User userRequest){
        String response =userService.addUser(userRequest);
        return response;
    }
}
