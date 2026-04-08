package com.vitor.relational_database_library.controllers;

import com.vitor.relational_database_library.entites.Loan;
import com.vitor.relational_database_library.entites.dto.CreateLoanDto;
import com.vitor.relational_database_library.services.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

@Controller
@RequestMapping("/v1/loan")
public class LoanController {

    private LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public ResponseEntity<Loan> registerLoan(@RequestBody CreateLoanDto dto){
        var loanId = loanService.register(dto);

        return ResponseEntity.created(URI.create("/v1/book/" + loanId.toString())).build();
    }
}
