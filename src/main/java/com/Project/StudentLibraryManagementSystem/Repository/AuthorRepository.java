package com.Project.StudentLibraryManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.StudentLibraryManagementSystem.Model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer>{
    
}
