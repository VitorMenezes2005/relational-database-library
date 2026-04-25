package com.vitor.relational_database_library.services;

import com.vitor.relational_database_library.entites.dto.LoanBookResponseDto;
import com.vitor.relational_database_library.repositories.LoanBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanBookService {

    private LoanBookRepository loanBookRepository;

    public LoanBookService(LoanBookRepository loanBookRepository) {
        this.loanBookRepository = loanBookRepository;
    }

    public List<LoanBookResponseDto> listLoans(){
        return loanBookRepository.findAll()
                .stream()
                .map(LoanBookResponseDto::from)
                .toList();
    }
}
