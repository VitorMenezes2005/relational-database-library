package com.vitor.relational_database_library.services;

import com.vitor.relational_database_library.entites.Client;
import com.vitor.relational_database_library.entites.Loan;
import com.vitor.relational_database_library.entites.LoanBook;
import com.vitor.relational_database_library.entites.LoanBookId;
import com.vitor.relational_database_library.entites.dto.CreateLoanDto;
import com.vitor.relational_database_library.entites.dto.LoanBookResponseDto;
import com.vitor.relational_database_library.repositories.BookRepository;
import com.vitor.relational_database_library.repositories.ClientRepository;
import com.vitor.relational_database_library.repositories.LoanBookRepository;
import com.vitor.relational_database_library.repositories.LoanRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class LoanService {

    private LoanRepository loanRepository;
    private ClientRepository clientRepository;
    private BookRepository bookRepository;
    private LoanBookRepository loanBookRepository;

    public LoanService(LoanRepository loanRepository,
                       ClientRepository clientRepository,
                       BookRepository bookRepository,
                       LoanBookRepository loanBookRepository) {
        this.loanRepository = loanRepository;
        this.clientRepository = clientRepository;
        this.bookRepository = bookRepository;
        this.loanBookRepository = loanBookRepository;
    }

    public UUID register(CreateLoanDto dto){

        var entity = new Loan(
                null,
                Instant.now(),
                dto.description(),
                null);

        var id = loanRepository.save(entity);

        return id.getLoanId();
    }

    public List<LoanBookResponseDto> listLoans(){
        return loanBookRepository.findAll()
                .stream()
                .map(LoanBookResponseDto::from)
                .toList();
    }

    public void associateClient(String loanId, String clientId){
        var loan = loanRepository.findById(UUID.fromString(loanId)).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        var client = clientRepository.findById(UUID.fromString(clientId)).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        loan.setClient(client);
        client.getLoans().add(loan);

        loanRepository.save(loan);
    }

    public void associateBook(String loanId, String bookId){
        var loan = loanRepository.findById(UUID.fromString(loanId)).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        var book = bookRepository.findById(UUID.fromString(bookId)).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        var id = new LoanBookId(loan.getLoanId(), book.getBookId());

        var entity = new LoanBook(
                id,
                loan,
                book);

        loanBookRepository.save(entity);
    }
}
