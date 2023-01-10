package com.Spring.SpringRest.service;

import com.Spring.SpringRest.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student addStudent(Student student);

    List<Student> getAllStudents();

    Optional<Student> findById(Long id);


}
