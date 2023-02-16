package com.Project.StudentLibraryManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.StudentLibraryManagementSystem.DTOs.IssueBookRequestDto;
import com.Project.StudentLibraryManagementSystem.Service.TransactionService;

@RestController
@RequestMapping("/transaction")

public class TransactionController {
   @Autowired
   TransactionService transactionService;
   
   @PostMapping("/issue-book")
   public String issueBook(@RequestBody IssueBookRequestDto issueDto){
    try{
        return transactionService.issueBook(issueDto);
    }
    catch(Exception e){
        return e.getMessage();
    }
   }
}
