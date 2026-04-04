package com.vitor.relational_database_library.controllers;

import com.vitor.relational_database_library.entites.Author;
import com.vitor.relational_database_library.services.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/author")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
}
