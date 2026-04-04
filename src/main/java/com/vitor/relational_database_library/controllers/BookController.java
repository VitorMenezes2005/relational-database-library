package com.vitor.relational_database_library.controllers;

import com.vitor.relational_database_library.entites.Book;
import com.vitor.relational_database_library.entites.dto.CreateBookDto;
import com.vitor.relational_database_library.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/v1/book")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> registerBook(@RequestBody CreateBookDto dto){
        var bookId = bookService.register(dto);

        return ResponseEntity.created(URI.create("/v1/book/" + bookId.toString())).build();
    }

    @GetMapping
    public ResponseEntity<List<Book>> listBooks(){
        List<Book> list = bookService.listAll();

        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/{id}/author/{authorId}")
    public ResponseEntity<Book> associateBookAuthor(@PathVariable("id") String bookId,
                                                    @PathVariable("authorId") String authorId){

        bookService.associateBookAuthor(bookId, authorId);
        
        return ResponseEntity.ok().build();
    }
}
