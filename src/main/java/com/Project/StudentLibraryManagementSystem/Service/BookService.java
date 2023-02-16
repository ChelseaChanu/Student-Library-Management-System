package com.Project.StudentLibraryManagementSystem.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.StudentLibraryManagementSystem.Converter.BookDtoToEntity;
import com.Project.StudentLibraryManagementSystem.DTOs.BookRequestDto;
import com.Project.StudentLibraryManagementSystem.Model.Author;
import com.Project.StudentLibraryManagementSystem.Model.Book;
import com.Project.StudentLibraryManagementSystem.Repository.AuthorRepository;
import com.Project.StudentLibraryManagementSystem.Repository.BookRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookService {
    
    @Autowired
    AuthorRepository authorRepository;
    BookRepository bookRepository;

    public String createBook(BookRequestDto bookDto){
        try{
            int authorId = bookDto.getAuthorId();
            Author author = authorRepository.findById(authorId).get();
            Book book = BookDtoToEntity.bookConverter(bookDto);
            book.setAuthor(author);
            List<Book> booksList= author.getListOfBooksWritten();
            booksList.add(book);
            authorRepository.save(author);
        }
        catch(Exception e){
            log.info("createBook has cause an error");
            return "Book cannot be created";
        }
        return "Book successfully created";
    }
}
