package com.example.dar_hw_3.service;

import com.example.dar_hw_3.exception.StudentException;
import com.example.dar_hw_3.model.Student;
import com.example.dar_hw_3.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new StudentException("Student with id " + id + " not found!"));
    }

    @Override
    @Transactional
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    @Transactional
    public void updateStudent(Long id, Student updatedStudent) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new StudentException("Student with id " + id + " not found!"));
        student.setName(updatedStudent.getName());
        student.setSurname(updatedStudent.getSurname());
        student.setAge(updatedStudent.getAge());
        student.setGpa(updatedStudent.getGpa());
        student.setStatus(updatedStudent.getStatus());
        studentRepository.save(student);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
