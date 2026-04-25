package com.vitor.relational_database_library.controllers;

import com.vitor.relational_database_library.entites.dto.LoanBookResponseDto;
import com.vitor.relational_database_library.services.LoanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/loanBook")
@Tag(name = "Empréstimo associados", description = "Visualizador de empréstimos associados")
public class LoanBookController {

    private LoanService loanService;

    public LoanBookController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    @Operation(summary = "Listar os empréstimos associados", description = "Lista todos os empréstimos cadastrados com as associações")
    public ResponseEntity<List<LoanBookResponseDto>> listAll(){
        List<LoanBookResponseDto> list = loanService.listLoansAssociates();

        return ResponseEntity.ok().body(list);
    }
}
