package com.vitor.relational_database_library.repositories;

import com.vitor.relational_database_library.entites.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoanRepository extends JpaRepository<Loan, UUID> {
}
