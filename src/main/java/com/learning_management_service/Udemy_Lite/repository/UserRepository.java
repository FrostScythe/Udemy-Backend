package com.learning_management_service.Udemy_Lite.repository;

import com.learning_management_service.Udemy_Lite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //it performs the database operations and it is the data layer
public interface UserRepository extends JpaRepository<User,Integer> {
}


