package com.vitor.relational_database_library.repositories;

import com.vitor.relational_database_library.entites.LoanBook;
import com.vitor.relational_database_library.entites.LoanBookId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanBookRepository extends JpaRepository<LoanBook, LoanBookId> {
}
