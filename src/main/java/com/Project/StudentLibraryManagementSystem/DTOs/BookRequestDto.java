package com.Project.StudentLibraryManagementSystem.DTOs;

import com.Project.StudentLibraryManagementSystem.Enum.Genre;

import lombok.Data;

@Data
public class BookRequestDto {
    private String name;
    private Genre bookGenre;
    private int numberOfPages;
    private double bookRating;
    private int authorId;
}
