package com.example.student_info_app.student_info_system.repository;

import com.example.student_info_app.student_info_system.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity,Integer> {

}
