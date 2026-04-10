package com.vitor.relational_database_library.controllers;

import com.vitor.relational_database_library.entites.Loan;
import com.vitor.relational_database_library.entites.dto.CreateLoanDto;
import com.vitor.relational_database_library.services.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Loan>> listAll(){
        List<Loan> list = loanService.listLoans();

        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/{id}/client/{clientId}")
    public ResponseEntity<Loan> associateLoanClient(@PathVariable("id") String loanId,
                                                    @PathVariable("clientId") String clientId){

        loanService.associateClient(loanId, clientId);

        return ResponseEntity.ok().build();
    }
}
