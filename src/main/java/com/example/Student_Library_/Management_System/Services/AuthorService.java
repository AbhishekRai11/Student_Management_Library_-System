package com.example.Student_Library_.Management_System.Services;

import com.example.Student_Library_.Management_System.DTOs.AuthorEntryDto;
import com.example.Student_Library_.Management_System.DTOs.AuthorResponseDto;
import com.example.Student_Library_.Management_System.DTOs.BookResponseDto;
import com.example.Student_Library_.Management_System.Model.Author;
import com.example.Student_Library_.Management_System.Model.Book;
import com.example.Student_Library_.Management_System.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public AuthorResponseDto getAuthor(Integer authorId){
        Author author= authorRepository.findById(authorId).get();
        AuthorResponseDto authorResponseDto=new AuthorResponseDto();

        List<Book> bookList=author.getBooksWritten();
        List<BookResponseDto> bookWrittenDto=new ArrayList<>();

        for(Book b:bookList){
            BookResponseDto bookResponseDto=new BookResponseDto();
            bookResponseDto.setGenre(b.getGenre());
            bookResponseDto.setPage(b.getPages());
            bookResponseDto.setName(b.getName());

            bookWrittenDto.add(bookResponseDto);
        }

        authorResponseDto.setBookWritten(bookWrittenDto);
        authorResponseDto.setAge(author.getAge());
        authorResponseDto.setName(author.getName());
        authorResponseDto.setCountry(author.getCountry());
        authorResponseDto.setRating(author.getRating());
        return authorResponseDto;
    }
}
