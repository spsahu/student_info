package com.example.student_info_app.student_info_system.service.impl;

import com.example.student_info_app.student_info_system.entity.AddressEntity;
import com.example.student_info_app.student_info_system.entity.CourseEntity;
import com.example.student_info_app.student_info_system.entity.StudentEntity;
import com.example.student_info_app.student_info_system.model.AddressDto;
import com.example.student_info_app.student_info_system.model.CourseDto;
import com.example.student_info_app.student_info_system.model.StudentDto;
import com.example.student_info_app.student_info_system.repository.StudentRepo;
import com.example.student_info_app.student_info_system.service.StudentServiceI;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentServiceI {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        StudentEntity studentEntity = new StudentEntity();
        CourseEntity courseEntity = new CourseEntity();
        AddressEntity addressEntity = new AddressEntity();
        BeanUtils.copyProperties(studentDto, studentEntity);
        BeanUtils.copyProperties(studentDto.getCourse().get(0), courseEntity);
        BeanUtils.copyProperties(studentDto.getAddressDto().get(0), addressEntity);
        List<CourseEntity> courseEntities = new ArrayList<>();
        List<AddressEntity> addressEntities = new ArrayList<>();
        courseEntities.add(courseEntity);
        addressEntities.add(addressEntity);
        studentEntity.setCourse(courseEntities);
        studentEntity.setAddress(addressEntities);

        StudentEntity saveData = studentRepo.save(studentEntity);
        if (saveData != null) {
            BeanUtils.copyProperties(saveData, studentDto);
            courseEntity = saveData.getCourse().get(0);
            addressEntity = saveData.getAddress().get(0);
            CourseDto courseDto = new CourseDto();
            AddressDto addressDto = new AddressDto();
            BeanUtils.copyProperties(courseEntity, courseDto);
            BeanUtils.copyProperties(addressEntity, addressDto);
            List<CourseDto> courseDtos = new ArrayList<>();
            List<AddressDto> addressDtos = new ArrayList<>();
            courseDtos.add(courseDto);
            addressDtos.add(addressDto);
            studentDto.setCourse(courseDtos);
            studentDto.setAddressDto(addressDtos);

            return studentDto;
        }
        return null;
    }

    @Override
    public List<StudentDto> getAllStudentDetails() {
        List<StudentEntity> studentEntities = studentRepo.findAll();
        List<StudentDto> studentDtoList = new ArrayList<>();
        studentEntities.forEach(record -> {
            StudentDto studentDto = new StudentDto();
            CourseDto courseDto = new CourseDto();
            AddressDto addressDto=new AddressDto();
            BeanUtils.copyProperties(record, studentDto);
            BeanUtils.copyProperties(record.getCourse().get(0), courseDto);
            BeanUtils.copyProperties(record.getAddress().get(0), addressDto);
            List<CourseDto> courseDtos = new ArrayList<>();
            List<AddressDto> addressDtos=new ArrayList<>();
            addressDtos.add(addressDto);
            courseDtos.add(courseDto);
            studentDto.setCourse(courseDtos);
            studentDto.setAddressDto(addressDtos);
            studentDtoList.add(studentDto);
        });
        return studentDtoList;
    }

    @Override
    public StudentDto getStudentById(Integer studentId) {
        Optional<StudentEntity> studentEntity = studentRepo.findById(studentId);
        StudentDto studentDto = new StudentDto();
        CourseDto courseDto = new CourseDto();
        BeanUtils.copyProperties(studentEntity.get().getCourse().get(0), courseDto);
        List<CourseDto> courseDtos = new ArrayList<>();
        courseDtos.add(courseDto);
        studentDto.setCourse(courseDtos);
        if (studentEntity.isPresent()) {
            BeanUtils.copyProperties(studentEntity.get(), studentDto);
            return studentDto;
        }
        return null;
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto) {
        StudentEntity studentEntity = new StudentEntity();
        CourseEntity courseEntity = new CourseEntity();
        BeanUtils.copyProperties(studentDto, studentEntity);
        BeanUtils.copyProperties(studentDto.getCourse().get(0), courseEntity);
        List<CourseEntity> courseEntities = new ArrayList<>();
        courseEntities.add(courseEntity);
        studentEntity.setCourse(courseEntities);
        StudentEntity entity = studentRepo.save(studentEntity);
        if (entity != null) {
            BeanUtils.copyProperties(entity, studentDto);
            CourseDto courseDto = new CourseDto();
            BeanUtils.copyProperties(courseEntity, courseDto);
            List<CourseDto> courseDtos = new ArrayList<>();
            courseDtos.add(courseDto);
            studentDto.setCourse(courseDtos);
            return studentDto;
        }
        return null;
    }
}
