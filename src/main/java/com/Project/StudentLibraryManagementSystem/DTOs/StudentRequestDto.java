package com.Project.StudentLibraryManagementSystem.DTOs;

import lombok.Data;

@Data
public class StudentRequestDto {
    private String name;
    private int age;
    private String country;
    private String email;
    private String mobileNo;
}
