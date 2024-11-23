package com.example.student_info_app.student_info_system.model;

import java.util.List;

public class StudentDto {

    private Integer sId;
    private String studentName;
    private List<CourseDto> course;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<CourseDto> getCourse() {
        return course;
    }

    public void setCourse(List<CourseDto> course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "sId=" + sId +
                ", studentName='" + studentName + '\'' +
                ", course=" + course +
                '}';
    }
}
