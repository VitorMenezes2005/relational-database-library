package com.vitor.relational_database_library.entites.dto;

import com.vitor.relational_database_library.entites.Loan;
import com.vitor.relational_database_library.entites.LoanBook;
import com.vitor.relational_database_library.entites.LoanBookId;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record LoanBookResponseDto(UUID clientId, LoanBookId loanBookId, String clientName, String email, String bookName, List<String> authors, Instant loanDate, String description) {

    public static LoanBookResponseDto from(LoanBook loanBook) {
        List<String> authors = loanBook.getBook().getAuthors()
                .stream()
                .map(author -> author.getName())
                .toList();

        return new LoanBookResponseDto(
                loanBook.getLoan().getClient().getClienteId(),
                loanBook.getId(),
                loanBook.getLoan().getClient().getName(),
                loanBook.getLoan().getClient().getEmail(),
                loanBook.getBook().getName(),
                authors,
                loanBook.getLoan().getLoanDate(),
                loanBook.getLoan().getDescription()
        );
    }
}
