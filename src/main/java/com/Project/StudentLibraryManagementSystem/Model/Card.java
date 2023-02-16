package com.Project.StudentLibraryManagementSystem.Model;

import java.util.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.Project.StudentLibraryManagementSystem.Enum.CardStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder

public class Card {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @CreationTimestamp
    private Date issuedDate;
    @UpdateTimestamp
    private Date updatedOn;
    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    //mapping with student
    @OneToOne
    @JoinColumn
    private Student student;

    //mapping with book
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Book> booksIsIssued;

    //mapping with transaction
    @OneToMany(mappedBy = "cardTransac", cascade = CascadeType.ALL)
    private List<Transaction> listOfTransactions;

}
