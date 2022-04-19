package com.example.j043.student.controller;

import com.example.j043.student.model.Student;
import com.example.j043.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    //create a GET endpoint to fetch all the students
    @GetMapping(value="/students")
    public ResponseEntity<List<Student>> getStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    //Creating a New Student
    @PostMapping(value="/students")
    public ResponseEntity<Student> newStudent(@RequestBody Student newStudent) {
        return new ResponseEntity<>(studentService.createNewStudent(newStudent), HttpStatus.OK);
    }

    @PutMapping(value="/students/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable int id, @RequestBody Student modifiedStudent) {
        Student student = studentService.updateStudent(modifiedStudent,id);
        return student == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(student,HttpStatus.OK);
    }

    @GetMapping(value="/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        return student == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(student,HttpStatus.OK);
    }

    @DeleteMapping(value="/students/{id}")
    public ResponseEntity<Student> deletStudent(@PathVariable int id) {
        Boolean isDeleted = studentService.deleteStudent(id);
        return !isDeleted ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(HttpStatus.OK);
    }

    //TODO find Student by FirstName
    //TODO find Student by FirstNameAndLastName
    //TODO find Student whose age is greater than 20
    //TODO PUT a validation in Student POST/PUT end point to not save a student whose age is less than 18
}
