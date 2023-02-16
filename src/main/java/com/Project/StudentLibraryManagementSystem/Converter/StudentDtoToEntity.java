package com.Project.StudentLibraryManagementSystem.Converter;

import com.Project.StudentLibraryManagementSystem.DTOs.StudentRequestDto;
import com.Project.StudentLibraryManagementSystem.Model.Student;

public class StudentDtoToEntity {
    public static Student studentConverter(StudentRequestDto studentDto){
        Student student = Student.builder().name(studentDto.getName()).age(studentDto.getAge())
        .country(studentDto.getCountry()).email(studentDto.getEmail()).mobileNo(studentDto.getMobileNo())
        .build();
        return student;
    }
}
