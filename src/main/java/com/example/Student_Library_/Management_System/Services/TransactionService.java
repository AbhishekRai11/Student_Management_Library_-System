package com.example.Student_Library_.Management_System.Services;

import com.example.Student_Library_.Management_System.DTOs.IssuedBookRequestDtos;

import com.example.Student_Library_.Management_System.Enums.CardStatus;
import com.example.Student_Library_.Management_System.Enums.TransactionStatus;
import com.example.Student_Library_.Management_System.Model.Book;
import com.example.Student_Library_.Management_System.Model.Card;
import com.example.Student_Library_.Management_System.Model.Transactions;
import com.example.Student_Library_.Management_System.Repositories.BookRepository;
import com.example.Student_Library_.Management_System.Repositories.CardRepository;
import com.example.Student_Library_.Management_System.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardRepository;

    public String issueBook(IssuedBookRequestDtos issuedBookRequestDtos)throws Exception{
        int bookId=issuedBookRequestDtos.getBookId();
        int cardId=issuedBookRequestDtos.getCardId();
        Book book= bookRepository.findById(bookId).get();
        Card card=cardRepository.findById(cardId).get();

        Transactions transactions=new Transactions();
        transactions.setBook(book);
        transactions.setCard(card);
        transactions.setTransactionId(UUID.randomUUID().toString());
        transactions.setIssueOperation(true);
        transactions.setTransactionStatus(TransactionStatus.PENDING);

        if(book==null || book.isIssued()==true){
            transactions.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transactions);
            throw new Exception("Book is not available");
        }

        if(card==null || card.getCardStatus()!= CardStatus.Activated){
            transactions.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transactions);
            throw new Exception("Card is not valid");
        }

        transactions.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(true);
        List<Transactions> listOfTransactionForBook=book.getListOfTransactions();
        listOfTransactionForBook.add(transactions);
        book.setListOfTransactions(listOfTransactionForBook);

        List<Book> issuedbookForCard=card.getBookIssued();
        issuedbookForCard.add(book);
        card.setBookIssued(issuedbookForCard);


        List<Transactions> transactionListOfCard=card.getListOfTransactions();
        transactionListOfCard.add(transactions);
        card.setListOfTransactions(transactionListOfCard);

        cardRepository.save(card);

        return "Book issud successful";
    }
}
