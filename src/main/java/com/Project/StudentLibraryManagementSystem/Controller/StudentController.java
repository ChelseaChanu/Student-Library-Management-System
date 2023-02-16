package com.Project.StudentLibraryManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.StudentLibraryManagementSystem.DTOs.StudentRequestDto;
import com.Project.StudentLibraryManagementSystem.Service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    
    @Autowired
    StudentService studentService;

    @PostMapping("/add-student")
    public ResponseEntity<String> createStudent(@RequestBody StudentRequestDto studentDto){
        String response = studentService.createStudent(studentDto);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
}
