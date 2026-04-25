package com.vitor.relational_database_library.controllers;

import com.vitor.relational_database_library.entites.Loan;
import com.vitor.relational_database_library.entites.LoanBook;
import com.vitor.relational_database_library.entites.dto.CreateLoanDto;
import com.vitor.relational_database_library.entites.dto.LoanBookResponseDto;
import com.vitor.relational_database_library.services.LoanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/loan")
@Tag(name = "Empréstimo", description = "Gerenciador de empréstimos")
public class LoanController {

    private LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    @Operation(summary = "Registrar um novo empréstimo", description = "Registra um novo empréstimo a partir do preenchimento de um DTO")
    public ResponseEntity<Loan> registerLoan(@RequestBody CreateLoanDto dto){
        var loanId = loanService.register(dto);

        return ResponseEntity.created(URI.create("/v1/book/" + loanId.toString())).build();
    }

    @GetMapping
    @Operation(summary = "Listar todos os empréstimos", description = "Lista todos os empréstimos cadastrados com as associações")
    public ResponseEntity<List<Loan>> listAll(){
        List<Loan> list = loanService.listAll();

        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/{id}/client/{clientId}")
    @Operation(summary = "Associar empréstimo com cliente", description = "Associa um empréstimo já registrado com um cliente já cadastrado")
    public ResponseEntity<Loan> associateLoanClient(@PathVariable("id") String loanId,
                                                    @PathVariable("clientId") String clientId){

        loanService.associateClient(loanId, clientId);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/book/{bookId}")
    @Operation(summary = "Associar empréstimo com livro", description = "Associa um empréstimo já registrado com um livro já cadastrado")
    public ResponseEntity<Loan> associateLoanBook(@PathVariable("id") String loanId,
                                                  @PathVariable("bookId") String bookId){

        loanService.associateBook(loanId, bookId);

        return ResponseEntity.ok().build();
    }
}
