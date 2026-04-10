package com.vitor.relational_database_library.services;

import com.vitor.relational_database_library.entites.Client;
import com.vitor.relational_database_library.entites.Loan;
import com.vitor.relational_database_library.entites.dto.CreateLoanDto;
import com.vitor.relational_database_library.repositories.ClientRepository;
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

    public LoanService(LoanRepository loanRepository,
                       ClientRepository clientRepository) {
        this.loanRepository = loanRepository;
        this.clientRepository = clientRepository;
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

    public List<Loan> listLoans(){
        return loanRepository.findAll();
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
}
