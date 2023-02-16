package com.Project.StudentLibraryManagementSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.StudentLibraryManagementSystem.DTOs.IssueBookRequestDto;
import com.Project.StudentLibraryManagementSystem.Enum.CardStatus;
import com.Project.StudentLibraryManagementSystem.Enum.TransactionStatus;
import com.Project.StudentLibraryManagementSystem.Model.Book;
import com.Project.StudentLibraryManagementSystem.Model.Card;
import com.Project.StudentLibraryManagementSystem.Model.Transaction;
import com.Project.StudentLibraryManagementSystem.Repository.BookRepository;
import com.Project.StudentLibraryManagementSystem.Repository.CardRepository;
import com.Project.StudentLibraryManagementSystem.Repository.TransactionRepository;

@Service
public class TransactionService {
    
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardRepository;

    public String issueBook(IssueBookRequestDto issueDto)throws Exception{
        int cardId = issueDto.getCardId();
        int bookId = issueDto.getBookId();

        Book book = bookRepository.findById(bookId).get();
        Card card = cardRepository.findById(cardId).get();
        
        Transaction transaction = new Transaction();
        transaction.setBookTransac(book);
        transaction.setCardTransac(card);
        transaction.setTransactionStatus(TransactionStatus.PENDING);
        transaction.setIssuedOperation(true);

        if(book==null || book.isIssued()==true){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is not available");
        }

        if(card==null || card.getCardStatus()!=CardStatus.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("invalid card input");
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);

        book.setIssued(true);
        book.getListOfBookTransaction().add(transaction);

        card.getBooksIsIssued().add(book);

        card.getListOfTransactions().add(transaction);

        cardRepository.save(card);
        return "Booked issued successfully";
    }
}
