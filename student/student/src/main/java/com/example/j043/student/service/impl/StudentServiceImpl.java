package com.example.j043.student.service.impl;

import com.example.j043.student.model.Student;
import com.example.j043.student.repository.StudentRepository;
import com.example.j043.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        studentRepository.findAll().forEach(studentList::add);
        return studentList;
    }

    @Override
    public Student createNewStudent(Student newStudent) {
        return studentRepository.save(newStudent);
    }

    @Override
    public Student updateStudent(Student modifiedStudent, int id) {
        //To verify if the id exist
        return studentRepository.findById(id).map(student->{
            student.setFirstName(modifiedStudent.getFirstName());
            student.setLastName(modifiedStudent.getLastName());
            return studentRepository.save(student);
        }).orElseGet(()->{return null;});
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id)
                .map(student -> {return student;})
                .orElseGet(()->{return null;});
    }

    @Override
    public Boolean deleteStudent(int id) {
        return studentRepository.findById(id)
                .map(student -> {
                    studentRepository.delete(student);
                    return true;})
                .orElseGet(()->{return false;});
    }
}
