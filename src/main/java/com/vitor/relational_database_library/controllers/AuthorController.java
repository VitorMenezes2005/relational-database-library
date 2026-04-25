package com.vitor.relational_database_library.controllers;

import com.vitor.relational_database_library.entites.Author;
import com.vitor.relational_database_library.entites.dto.CreateAuthorDto;
import com.vitor.relational_database_library.services.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/author")
@Tag(name = "Autor", description = "Gerenciador de autores")
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    @Operation(summary = "Registrar um novo autor", description = "Registra um novo autor a partir do preenchimento de um DTO")
    public ResponseEntity<Author> registerAuthor(@RequestBody CreateAuthorDto dto){
        var authorId = authorService.register(dto);

        return ResponseEntity.created(URI.create("/v1/author/" + authorId.toString())).build();
    }

    @GetMapping
    @Operation(summary = "Listar todos os autorees", description = "Lista todos os autores cadastrados no banco de dados")
    public ResponseEntity<List<Author>> listAuthors(){
        List<Author> list = authorService.listAll();

        return ResponseEntity.ok().body(list);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um autor", description = "Deleta um autor do banco de dados a partir do id dele")
    public ResponseEntity<Void> deletedById(@PathVariable UUID id){
        authorService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
