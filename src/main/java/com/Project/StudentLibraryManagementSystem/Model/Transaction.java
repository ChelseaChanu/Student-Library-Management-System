package com.Project.StudentLibraryManagementSystem.Model;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.Project.StudentLibraryManagementSystem.Enum.TransactionStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@Data
@AllArgsConstructor

public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String transactionId = UUID.randomUUID().toString();
    @CreationTimestamp
    private Date transactionDate;
    private int fine;
    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;
    private boolean isIssuedOperation;

    //mapping with card
    @ManyToOne
    @JoinColumn
    private Card cardTransac;

    //mapping with book
    @ManyToOne
    @JoinColumn
    private Book bookTransac;
}
