package com.vitor.relational_database_library.entites;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID authorId;

    @Column(name = "name")
    private String name;

    @Column(name = "nationality")
    private String nationality;

    public Author() {
    }

    public Author(UUID authorId, String name, String nationality) {
        this.authorId = authorId;
        this.name = name;
        this.nationality = nationality;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
