package com.Project.StudentLibraryManagementSystem.Converter;

import com.Project.StudentLibraryManagementSystem.DTOs.AuthorRequestDto;
import com.Project.StudentLibraryManagementSystem.Model.Author;

public class AuthorDtoToEntity {
    
    public static Author authorConverter(AuthorRequestDto authorDto){
        Author author = Author.builder().name(authorDto.getName())
                        .age(authorDto.getAge()).country(authorDto.getCountry())
                        .build();
        return author;
    }
}
