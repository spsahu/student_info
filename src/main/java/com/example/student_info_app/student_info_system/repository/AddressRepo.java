package com.example.student_info_app.student_info_system.repository;


import com.example.student_info_app.student_info_system.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<AddressEntity,Integer> {
}
