package com.student.Assignment.service;

import java.util.List;
import com.student.Assignment.entity.Student;
public interface StudentService {
    Student createStudent(Student student);
    Student getStudentById(int id);
    List<Student> getAllStudents();
    Student updateStudentById(Student student);
    void deleteStudentById(int id);
}

