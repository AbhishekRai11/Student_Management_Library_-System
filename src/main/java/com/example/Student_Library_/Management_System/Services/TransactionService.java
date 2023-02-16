package com.example.Student_Library_.Management_System.Services;

import com.example.Student_Library_.Management_System.DTOs.IssuedBookRequestDtos;
import com.example.Student_Library_.Management_System.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public String issueBook(IssuedBookRequestDtos issuedBookRequestDtos){
        return "";
    }
}
