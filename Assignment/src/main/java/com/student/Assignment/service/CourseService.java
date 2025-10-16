package com.student.Assignment.service;


import com.student.Assignment.entity.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course);
    Course getCourseById(int id);
    List<Course> getAllCourses();
    void deleteCourseById(int id);
}
