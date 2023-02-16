package com.example.Student_Library_.Management_System.Services;

import com.example.Student_Library_.Management_System.DTOs.StudentUpdateModDTOs;
import com.example.Student_Library_.Management_System.Enums.CardStatus;
import com.example.Student_Library_.Management_System.Model.Card;
import com.example.Student_Library_.Management_System.Model.Student;
import com.example.Student_Library_.Management_System.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;


    public String createStudent(Student student){
        Card card=new Card();
        card.setCardStatus(CardStatus.Activated);
        card.setStudentVariableName(student);


        student.setCard(card);
        studentRepository.save(student);
        return "";
    }
    public String getNameByUser(String email){
        Student student=studentRepository.findByEmail(email);
        return student.getName();
    }

    public String updateMob(StudentUpdateModDTOs studentUpdateModDTOs){
        Student originalStudent=studentRepository.findById(studentUpdateModDTOs.getId()).get();
        originalStudent.setMobNo(studentUpdateModDTOs.getMobNO());
        studentRepository.save(originalStudent);
        return "Student Mob update";
    }
}
