package com.example.Student_Library_.Management_System.DTOs;

import com.example.Student_Library_.Management_System.Enums.Genre;

public class BookResponseDto {
    private String name;
    private Integer page;

    private Genre genre;

    public BookResponseDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }



    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
