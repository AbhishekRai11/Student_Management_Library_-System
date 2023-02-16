package com.example.Student_Library_.Management_System.Services;

import com.example.Student_Library_.Management_System.DTOs.AuthorEntryDto;
import com.example.Student_Library_.Management_System.Model.Author;
import com.example.Student_Library_.Management_System.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public String createAuthor(AuthorEntryDto authorEntryDto){

        Author author=new Author();
        author.setName(authorEntryDto.getName());
        author.setAge(authorEntryDto.getAge());
        author.setCountry(authorEntryDto.getCountry());
        author.setRating(authorEntryDto.getRating());
        authorRepository.save(author);
        return "Author add successfully";
    }
}
