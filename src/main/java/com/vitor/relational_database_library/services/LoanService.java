package com.vitor.relational_database_library.services;

import com.vitor.relational_database_library.entites.Loan;
import com.vitor.relational_database_library.entites.dto.CreateLoanDto;
import com.vitor.relational_database_library.repositories.LoanRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class LoanService {

    private LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
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
}
