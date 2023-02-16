package com.Project.StudentLibraryManagementSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.StudentLibraryManagementSystem.Converter.StudentDtoToEntity;
import com.Project.StudentLibraryManagementSystem.DTOs.StudentRequestDto;
import com.Project.StudentLibraryManagementSystem.Enum.CardStatus;
import com.Project.StudentLibraryManagementSystem.Model.Card;
import com.Project.StudentLibraryManagementSystem.Model.Student;
import com.Project.StudentLibraryManagementSystem.Repository.StudentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentService {
    
    @Autowired
    StudentRepository studentRepository;

    public String createStudent(StudentRequestDto studentDto){
        try{
            Card card = new Card();
            card.setCardStatus(CardStatus.ACTIVATED);
            Student student = StudentDtoToEntity.studentConverter(studentDto);
            card.setStudent(student);
            student.setCard(card);
            studentRepository.save(student);
        }
        catch(Exception e){
            log.info("createStudent has cause an error.");
            return "Student cannot be created";
        }
        return "Student successfully created and card assigned";
    }
}
