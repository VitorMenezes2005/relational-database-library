package com.vitor.relational_database_library.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class LoanBookId {

    @Column(name = "loan_id")
    private UUID loanId;

    @Column(name = "book_id")
    private UUID bookId;

    public LoanBookId() {
    }

    public LoanBookId(UUID loanId, UUID bookId) {
        this.loanId = loanId;
        this.bookId = bookId;
    }

    public UUID getLoanId() {
        return loanId;
    }

    public void setLoanId(UUID loanId) {
        this.loanId = loanId;
    }

    public UUID getBookId() {
        return bookId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }
}
