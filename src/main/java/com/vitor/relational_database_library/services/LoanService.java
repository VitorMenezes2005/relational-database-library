package com.vitor.relational_database_library.services;

import com.vitor.relational_database_library.repositories.LoanRepository;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    private LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
}
