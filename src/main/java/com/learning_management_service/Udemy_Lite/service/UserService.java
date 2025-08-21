package com.learning_management_service.Udemy_Lite.service;

import com.learning_management_service.Udemy_Lite.model.User;
import com.learning_management_service.Udemy_Lite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(User userRequest){
    userRepository.save(userRequest);
    return "User saved successfully !!";
    }

    public User getUserById(int id){
        Optional<User> userOptional= userRepository.findById(id);
        if(userOptional.isPresent()){
            return userOptional.get();
        }else{
            return null;
        }
    }

    public String updateUser(int id, User newUserRequest){
        User existingUser = getUserById(id);
        if(existingUser != null){
            newUserRequest.setId(id); // Set the ID explicitly
            userRepository.save(newUserRequest);
            return "User updated successfully";
        } else {
            return "User not found, hence cannot be updated";
        }
    }

    public String deleteUserbyId(int id){
        userRepository.deleteById(id);
        return "UserStudent with id: " +id+" got deleted successfully!";
    }

}