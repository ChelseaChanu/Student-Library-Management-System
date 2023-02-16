package com.Project.StudentLibraryManagementSystem.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String country;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String mobileNo;
    private int numberOfBooksOwn;

    //card mapping
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Card card;
}
