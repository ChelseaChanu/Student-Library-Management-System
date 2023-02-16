package com.Project.StudentLibraryManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.StudentLibraryManagementSystem.DTOs.BookRequestDto;
import com.Project.StudentLibraryManagementSystem.Service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
    
    @Autowired
    BookService bookService;

    @PostMapping("/add-book")
    public ResponseEntity<String> createBook(@RequestBody BookRequestDto bookDto){
        String response = bookService.createBook(bookDto);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
}
