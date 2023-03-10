package com.example.Student_Library_.Management_System.Controllers;

import com.example.Student_Library_.Management_System.DTOs.AuthorEntryDto;
import com.example.Student_Library_.Management_System.DTOs.AuthorResponseDto;
import com.example.Student_Library_.Management_System.Model.Author;
import com.example.Student_Library_.Management_System.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @PostMapping("/add")
    public String createAuthor(@RequestBody AuthorEntryDto authorEntryDto){
        authorService.createAuthor(authorEntryDto);
        return "Author added Successful";
    }

    @GetMapping("/get")
    public AuthorResponseDto getAuthor(@RequestParam("authorId") Integer authorId){
        return authorService.getAuthor(authorId);
    }
}
