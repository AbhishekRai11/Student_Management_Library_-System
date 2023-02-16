package com.example.Student_Library_.Management_System.DTOs;

import javax.swing.*;

public class IssuedBookRequestDtos {
    private int cardId;
    private int bookId;

    public IssuedBookRequestDtos(){

    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
