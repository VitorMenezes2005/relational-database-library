package com.vitor.relational_database_library.entites;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.xml.crypto.Data;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID loanId;

    @CreationTimestamp
    @Column(name = "loanDate")
    private Instant loanDate;

    @ManyToMany
    @JoinTable(name = "loan_book",
            joinColumns = @JoinColumn(name = "loan_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;

    public Loan() {
    }

    public Loan(UUID loanId,
                Instant loanDate,
                List<Book> books) {
        this.loanId = loanId;
        this.loanDate = loanDate;
        this.books = books;
    }

    public UUID getLoanId() {
        return loanId;
    }

    public void setLoanId(UUID loanId) {
        this.loanId = loanId;
    }

    public Instant getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Instant loanDate) {
        this.loanDate = loanDate;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
