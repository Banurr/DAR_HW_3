package com.example.dar_hw_3.service;

import com.example.dar_hw_3.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    void createStudent(Student student);

    void updateStudent(Long id, Student student);

    void deleteStudent(Long id);
}
