package com.example.dar_hw_3.controller;

import com.example.dar_hw_3.model.Student;
import com.example.dar_hw_3.service.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentServiceImpl studentService;

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public void createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id,
                              @RequestBody Student student) {
        studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteMapping(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
