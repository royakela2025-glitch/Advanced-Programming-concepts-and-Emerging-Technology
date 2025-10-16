package com.student.Assignment.repository;

import com.student.Assignment.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Integer> {
}
