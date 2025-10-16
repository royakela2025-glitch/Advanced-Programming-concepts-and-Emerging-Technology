package com.student.Assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.student.Assignment.entity.Student;
import com.student.Assignment.service.StudentService;

@RequestMapping("student")
@RestController
public class StudentController {


    @Autowired
    public StudentService studentService;

    @PostMapping("create")
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        try{
            Student newStudent = studentService.createStudent(student);
            if (newStudent != null){
                return ResponseEntity.ok(newStudent);
            }else {
                return ResponseEntity.badRequest().body("An error occurred");
            }
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body("The student already exists");
        }
    }

    @GetMapping("find-all")
    public ResponseEntity<?> getAllStudent() {
        if(studentService.getAllStudents()!=null) {
            return ResponseEntity.ok(studentService.getAllStudents());
        }else  {
            return ResponseEntity.badRequest().body("An error occurred");
        }
    }

    @PutMapping("update/{studentId}")
    public ResponseEntity<?> updateStudent(@PathVariable int studentId, @RequestBody Student student){
        Student currentStudent = studentService.getStudentById(studentId);
        if(currentStudent == null){
            return ResponseEntity.badRequest().body("Student not found");
        }
        currentStudent.setFirstName(student.getFirstName());
        currentStudent.setLastName(student.getLastName());
        currentStudent.setEmail(student.getEmail());
        currentStudent.setPhoneNumber(student.getPhoneNumber());
        Student updatedStudent = studentService.createStudent(currentStudent);
        if(updatedStudent != null){
            return ResponseEntity.ok(updatedStudent);
        }else {
            return ResponseEntity.badRequest().body("An error occurred");
        }
    }

    @DeleteMapping("delete/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable int studentId) {
        Student currentStudent = studentService.getStudentById(studentId);
        if(currentStudent == null){
            return ResponseEntity.badRequest().body("Student not found");
        }
        studentService.deleteStudentById(studentId);
        return ResponseEntity.ok("Student has been deleted successfully");
    }


}
