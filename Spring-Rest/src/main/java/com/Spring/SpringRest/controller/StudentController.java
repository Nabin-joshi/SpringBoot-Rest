package com.Spring.SpringRest.controller;

import com.Spring.SpringRest.model.Student;
import com.Spring.SpringRest.repository.StudentRepository;
import com.Spring.SpringRest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class StudentController {

    public StudentService studentService;
    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentService studentService,
                             StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }


    @PostMapping("/student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        ResponseEntity<Student> responseEntity = new ResponseEntity<Student>(studentService.addStudent(student), HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/view")
    public List<Student> listStudent(){
       List<Student> students = new ArrayList<Student>(studentService.getAllStudents());
        return students;
    }

    @GetMapping("/view/{id}")
    public java.util.Optional<Student> getStudentById(@PathVariable("id") Long id){
        return studentService.findById(id);
    }
}
