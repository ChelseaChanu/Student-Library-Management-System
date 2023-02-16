package com.Project.StudentLibraryManagementSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.StudentLibraryManagementSystem.Converter.AuthorDtoToEntity;
import com.Project.StudentLibraryManagementSystem.DTOs.AuthorRequestDto;
import com.Project.StudentLibraryManagementSystem.Model.Author;
import com.Project.StudentLibraryManagementSystem.Repository.AuthorRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class AuthorService {
    
    @Autowired
	AuthorRepository authorRepository;
    
    public String createAuthor(AuthorRequestDto authorDto){
        try{
            Author author = AuthorDtoToEntity.authorConverter(authorDto);
            authorRepository.save(author);
        }
        catch(Exception e){
            log.info("createAuthor has caused an error");
            return "Author cannot be created";
        }
        return "Author successfully created";
    }

    public String updateAuthor(Integer authorId, AuthorRequestDto authorDto)throws Exception{
        Author author = authorRepository.findById(authorId).get();
        if(author!=null){
            author = AuthorDtoToEntity.authorConverter(authorDto);
            authorRepository.save(author);
        }
        else{
            throw new Exception( "Author does not exists");
        }
        return "Changes updated";
    }
}
