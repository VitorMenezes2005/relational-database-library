package com.vitor.relational_database_library.services;

import com.vitor.relational_database_library.entites.Book;
import com.vitor.relational_database_library.entites.dto.CreateBookDto;
import com.vitor.relational_database_library.repositories.AuthorRepository;
import com.vitor.relational_database_library.repositories.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository,
                       AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public UUID register(CreateBookDto dto) {

        var entity = new Book(
                null,
                dto.name(),
                dto.genre(),
                dto.year(),
                new ArrayList<>());

        var id = bookRepository.save(entity);

        return id.getBookId();
    }

    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    public void associateBookAuthor(String bookId, String authorId){
        var book = bookRepository.findById(UUID.fromString(bookId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        var author = authorRepository.findById(UUID.fromString(authorId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        book.getAuthors().add(author);
        author.getBooks().add(book);

        bookRepository.save(book);
    }
}
