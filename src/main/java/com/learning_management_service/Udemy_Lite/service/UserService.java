package com.learning_management_service.Udemy_Lite.service;

import com.learning_management_service.Udemy_Lite.dto.UserResponseDTO;
import com.learning_management_service.Udemy_Lite.dto.UserRequestDTO;
import com.learning_management_service.Udemy_Lite.model.User;
import com.learning_management_service.Udemy_Lite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Convert Entity → ResponseDTO
    private UserResponseDTO mapToResponseDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setDob(user.getDob());
        dto.setEmail(user.getEmail());
        dto.setMoblieNo(user.getMoblieNo());
        return dto;
    }

    // Convert RequestDTO → Entity
    private User mapToEntity(UserRequestDTO dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setDob(dto.getDob());
        user.setEmail(dto.getEmail());
        user.setMoblieNo(dto.getMoblieNo());
        return user;
    }

    // Update existing entity with RequestDTO data
    private void updateEntityFromDTO(User user, UserRequestDTO dto) {
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setDob(dto.getDob());
        user.setEmail(dto.getEmail());
        user.setMoblieNo(dto.getMoblieNo());
    }

    //Create
    public UserResponseDTO createUser(UserRequestDTO userRequest) {
        User user = mapToEntity(userRequest);

        User savedUser = userRepository.save(user);
        return mapToResponseDTO(savedUser);
    }

    //Get ALL
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream().map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    //Get by ID
    public Optional<UserResponseDTO> getUserById(Long id) {
        return userRepository.findById(id).map(this::mapToResponseDTO);
    }

    //Update
    public UserResponseDTO updateUser(Long id, UserRequestDTO newUserRequest) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found" + id));

        updateEntityFromDTO(user, newUserRequest);
       User updatedUser= userRepository.save(user);
        return mapToResponseDTO(updatedUser);
    }

    //Delete
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User with id: " + id + " got deleted successfully!";
    }

}