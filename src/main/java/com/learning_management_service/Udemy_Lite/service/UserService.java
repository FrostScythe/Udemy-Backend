package com.learning_management_service.Udemy_Lite.service;

import com.learning_management_service.Udemy_Lite.model.User;
import com.learning_management_service.Udemy_Lite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(User userRequest){
    userRepository.save(userRequest);
    return "User saved successfully";
    }

}