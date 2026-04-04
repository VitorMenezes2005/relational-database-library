package com.vitor.relational_database_library.repositories;

import com.vitor.relational_database_library.entites.Author;
import com.vitor.relational_database_library.entites.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
