package com.vitor.relational_database_library.controllers;

import com.vitor.relational_database_library.entites.Author;
import com.vitor.relational_database_library.entites.dto.CreateAuthorDto;
import com.vitor.relational_database_library.services.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/v1/author")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<Author> registerAuthor(@RequestBody CreateAuthorDto dto){
        var authorId = authorService.register(dto);

        return ResponseEntity.created(URI.create("/v1/author/" + authorId.toString())).build();
    }

    @GetMapping
    public ResponseEntity<List<Author>> listAuthors(){
        List<Author> list = authorService.listAll();

        return ResponseEntity.ok().body(list);
    }
}
