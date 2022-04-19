package com.example.j043.student.repository;

import com.example.j043.student.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Integer> {
}
