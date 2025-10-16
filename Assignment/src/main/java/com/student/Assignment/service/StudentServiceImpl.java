package com.student.Assignment.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.student.Assignment.entity.Student;
import com.student.Assignment.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService  {
    @Autowired
    public StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudentById(Student student) {
        return null;
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }
}


