package com.vitor.relational_database_library.entites;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_loan_book")
public class LoanBook {

    @EmbeddedId
    private LoanBookId id;

    @ManyToOne
    @MapsId("loanId")
    @JoinColumn(name = "loan_id")
    private Loan loan;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id")
    private Book book;

    public LoanBook() {
    }

    public LoanBook(LoanBookId id, Loan loan, Book book) {
        this.id = id;
        this.loan = loan;
        this.book = book;
    }

    public LoanBookId getId() {
        return id;
    }

    public void setId(LoanBookId id) {
        this.id = id;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}


