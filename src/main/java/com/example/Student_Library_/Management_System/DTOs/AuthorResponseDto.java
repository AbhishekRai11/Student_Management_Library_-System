package com.example.Student_Library_.Management_System.DTOs;

import java.util.List;

public class AuthorResponseDto {
    private String name;
    private Integer age;
    private String country;

    private double rating;
    private List<BookResponseDto> bookWritten;

    public AuthorResponseDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<BookResponseDto> getBookWritten() {
        return bookWritten;
    }

    public void setBookWritten(List<BookResponseDto> bookWritten) {
        this.bookWritten = bookWritten;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
