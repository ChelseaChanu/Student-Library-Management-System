package com.Project.StudentLibraryManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.StudentLibraryManagementSystem.Model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer>{
    
}
