package com.student.Assignment.controller;

import com.student.Assignment.entity.Course;
import com.student.Assignment.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/course")
@RestController
public class CourseController {
    @Autowired
    public CourseService courseService;

    @PostMapping("create")
    public ResponseEntity<?> createCourse(@RequestBody Course course) {
        try {
            Course newCourse = courseService.createCourse(course);
            if (newCourse != null) {
                return ResponseEntity.ok(newCourse);
            } else {
                return ResponseEntity.badRequest().body("An error occured");
            }
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body("The course already exists");
        }
    }

    @GetMapping("find-all")
    public ResponseEntity<?> getAllCourses() {
        if (courseService.getAllCourses() != null) {
            return ResponseEntity.ok(courseService.getAllCourses());
        } else {
            return ResponseEntity.badRequest().body("An error occurred");
        }
    }
}
