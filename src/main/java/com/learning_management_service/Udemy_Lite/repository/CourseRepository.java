package com.learning_management_service.Udemy_Lite.repository;

import com.learning_management_service.Udemy_Lite.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
}