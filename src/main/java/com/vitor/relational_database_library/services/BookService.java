package com.vitor.relational_database_library.services;

import com.vitor.relational_database_library.entites.Book;
import com.vitor.relational_database_library.entites.dto.CreateBookDto;
import com.vitor.relational_database_library.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public UUID register(CreateBookDto dto) {

        var entity = new Book(
                null,
                dto.name(),
                dto.genre(),
                dto.year());

        var id = bookRepository.save(entity);

        return id.getBookId();
    }

    public List<Book> listAll() {
        return bookRepository.findAll();
    }
}
