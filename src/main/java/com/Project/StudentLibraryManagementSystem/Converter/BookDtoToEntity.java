package com.Project.StudentLibraryManagementSystem.Converter;

import com.Project.StudentLibraryManagementSystem.DTOs.BookRequestDto;
import com.Project.StudentLibraryManagementSystem.Model.Book;

public class BookDtoToEntity {
    
    public static Book bookConverter(BookRequestDto bookDto){
        Book book = Book.builder().name(bookDto.getName()).bookGenre(bookDto.getBookGenre())
        .numberOfPages(bookDto.getNumberOfPages()).bookRating(bookDto.getBookRating())
        .build();
        return book;
    }
}
