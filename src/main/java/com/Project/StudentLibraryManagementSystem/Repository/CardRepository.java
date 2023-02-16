package com.Project.StudentLibraryManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.StudentLibraryManagementSystem.Model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer>{
    
}
