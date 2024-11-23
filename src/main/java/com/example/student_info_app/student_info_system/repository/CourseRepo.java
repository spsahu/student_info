package com.example.student_info_app.student_info_system.repository;

import com.example.student_info_app.student_info_system.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<CourseEntity,Integer> {
}
