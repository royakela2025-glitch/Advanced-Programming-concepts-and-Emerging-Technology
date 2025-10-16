package com.student.Assignment.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.student.Assignment.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
