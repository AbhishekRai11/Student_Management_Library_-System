package com.example.Student_Library_.Management_System.Controllers;

import com.example.Student_Library_.Management_System.DTOs.IssuedBookRequestDtos;
import com.example.Student_Library_.Management_System.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;


    @PostMapping("/issueBook")
    public String issueBook(@RequestBody IssuedBookRequestDtos issuedBookRequestDtos){
        try{

        return transactionService.issueBook(issuedBookRequestDtos);
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}
