package com.Project.StudentLibraryManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.StudentLibraryManagementSystem.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
    
}
