package com.vitor.relational_database_library.controllers;

import com.vitor.relational_database_library.entites.Book;
import com.vitor.relational_database_library.entites.dto.CreateBookDto;
import com.vitor.relational_database_library.services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/book")
@Tag(name = "Livro", description = "Gerenciador de livros")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @Operation(summary = "Registrar um novo livro", description = "Registra um novo livro a partir do preenchimento de um DTO")
    public ResponseEntity<Book> registerBook(@RequestBody CreateBookDto dto){
        var bookId = bookService.register(dto);

        return ResponseEntity.created(URI.create("/v1/book/" + bookId.toString())).build();
    }

    @GetMapping
    @Operation(summary = "Listar todos os livros", description = "Lista todos os livros cadastrados no banco de dados")
    public ResponseEntity<List<Book>> listBooks(){
        List<Book> list = bookService.listAll();

        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/{id}/author/{authorId}")
    @Operation(summary = "Associar livro com autor", description = "Associa um livro já registrado com um autor já cadastrado")
    public ResponseEntity<Book> associateBookAuthor(@PathVariable("id") String bookId,
                                                    @PathVariable("authorId") String authorId){

        bookService.associateBookAuthor(bookId, authorId);
        
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um livro", description = "Deleta um livro do banco de dados a partir do id dele")
    public ResponseEntity<Void> deletedById(@PathVariable UUID id){
        bookService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
