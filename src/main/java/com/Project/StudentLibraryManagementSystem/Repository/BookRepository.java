package com.Project.StudentLibraryManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.StudentLibraryManagementSystem.Model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{
    
}
