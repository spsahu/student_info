package com.example.student_info_app.student_info_system.service;

import com.example.student_info_app.student_info_system.model.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentServiceI {

    public StudentDto saveStudent(StudentDto studentDto);

    public List<StudentDto> getAllStudentDetails();

    public StudentDto getStudentById(Integer studentId);

    public StudentDto updateStudent(StudentDto studentDto);
}
