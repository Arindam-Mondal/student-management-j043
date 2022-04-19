package com.example.j043.student.service;

import com.example.j043.student.model.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();
    public Student createNewStudent(Student newStudent);
    public Student updateStudent(Student modifiedStudent,int id);
    public Student getStudentById(int id);
    public Boolean deleteStudent(int id);
}
