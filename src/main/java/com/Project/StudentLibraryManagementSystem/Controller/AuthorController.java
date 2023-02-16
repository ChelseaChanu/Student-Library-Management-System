package com.Project.StudentLibraryManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Project.StudentLibraryManagementSystem.DTOs.AuthorRequestDto;
import com.Project.StudentLibraryManagementSystem.Service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {
    
    @Autowired
	AuthorService authorService;
    
    @PostMapping("/add-author")
    public ResponseEntity<String> createAuthor(@RequestBody AuthorRequestDto authorDto){
        String response = authorService.createAuthor(authorDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update-author-details")
    public ResponseEntity<String> updateDetails(@RequestParam Integer authorId, @RequestBody AuthorRequestDto authorDto)throws Exception{
        String response = authorService.updateAuthor(authorId, authorDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
