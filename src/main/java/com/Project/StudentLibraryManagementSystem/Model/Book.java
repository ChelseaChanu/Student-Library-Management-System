package com.Project.StudentLibraryManagementSystem.Model;

import java.util.*;

import com.Project.StudentLibraryManagementSystem.Enum.Genre;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private Genre bookGenre;
    private int numberOfPages;
    private double bookRating;
    private boolean isIssued;

    //mapping with author
    @ManyToOne
    @JoinColumn
    private Author author;

    //mapping with card
    @ManyToOne
    @JoinColumn
    private Card card;

    //mapping with transaction
    @OneToMany(mappedBy = "bookTransac", cascade = CascadeType.ALL)
    private List<Transaction> listOfBookTransaction;
}
