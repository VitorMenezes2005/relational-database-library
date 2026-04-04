package com.vitor.relational_database_library.services;

import com.vitor.relational_database_library.entites.Author;
import com.vitor.relational_database_library.entites.dto.CreateAuthorDto;
import com.vitor.relational_database_library.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public UUID register(CreateAuthorDto dto){

        var entity = new Author(
                null,
                dto.name(),
                dto.nationality(),
                new ArrayList<>());

        var authorId = authorRepository.save(entity);

        return authorId.getAuthorId();
    }

    public List<Author> listAll(){
        return authorRepository.findAll();
    }
}
