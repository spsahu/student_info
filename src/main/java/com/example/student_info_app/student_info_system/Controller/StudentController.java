package com.example.student_info_app.student_info_system.Controller;

import com.example.student_info_app.student_info_system.model.StudentDto;
import com.example.student_info_app.student_info_system.service.StudentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentServiceI studentServiceI;

    @PostMapping("/saveStudent")
    public ResponseEntity<?> saveStudent(@RequestBody StudentDto studentDto){


        StudentDto savedStudent = studentServiceI.saveStudent(studentDto);
        if(savedStudent != null) {
            return ResponseEntity.ok(savedStudent);
        }
        return ResponseEntity.badRequest().body("Please give Data in proper format!!");
    }

    @GetMapping("/getAllStudent")
    public ResponseEntity<?> getAllStudent(){
        List<StudentDto> allStudentDetails = studentServiceI.getAllStudentDetails();
        if(allStudentDetails != null && !allStudentDetails.isEmpty()){
            return ResponseEntity.ok(allStudentDetails);
        }
        return ResponseEntity.ok("No Data Found!!");
    }

    @GetMapping("/getById/{sid}")
    public ResponseEntity<?> getStudentById(@PathVariable("sid") Integer studentId){

        StudentDto studentById = studentServiceI.getStudentById(studentId);
        if( studentById != null ){
            return ResponseEntity.ok(studentById);
        }
        return ResponseEntity.ok("Data not available for this Student Id");
    }

    @PatchMapping("/updateStudent")
    public ResponseEntity<?> updateStudent(@RequestBody StudentDto studentDto){
        StudentDto updateStudent = studentServiceI.updateStudent(studentDto);
        if( updateStudent != null ){
            return ResponseEntity.ok( updateStudent );
        }
        return ResponseEntity.badRequest().body("Data not updated !!");
    }

}
