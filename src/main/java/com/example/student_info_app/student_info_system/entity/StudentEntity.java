package com.example.student_info_app.student_info_system.entity;

import com.example.student_info_app.student_info_system.model.AddressDto;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_student")
public class StudentEntity {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sId;

    @Column(name = "student_name")
    private String studentName;

    @OneToMany(targetEntity = CourseEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_fk", referencedColumnName = "student_id")
    private List<CourseEntity> course;

    @OneToMany(targetEntity = AddressEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "ap_fk", referencedColumnName = "student_id")
    private List<AddressEntity> address;

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

    public List<CourseEntity> getCourse() {
        return course;
    }

    public void setCourse(List<CourseEntity> course) {
        this.course = course;
    }

    public List<AddressEntity> getAddress() {
        return address;
    }

    public void setAddress(List<AddressEntity> address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "sId=" + sId +
                ", studentName='" + studentName + '\'' +
                ", course=" + course +
                ", address=" + address +
                '}';
    }
}
