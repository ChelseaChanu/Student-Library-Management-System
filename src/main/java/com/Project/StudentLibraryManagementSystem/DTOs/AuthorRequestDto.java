package com.Project.StudentLibraryManagementSystem.DTOs;

import lombok.Data;

@Data
public class AuthorRequestDto {
    private String name;
    private int age;
    private String country;
}
