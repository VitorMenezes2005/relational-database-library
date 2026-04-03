package com.vitor.relational_database_library.entites;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID bookId;

    @Column(name = "name")
    private String name;

    @Column(name = "genre")
    private String genre;

    @Column(name = "yearPublication")
    private Integer year;

    public Book() {
    }

    public Book(UUID bookId,
                String name,
                String genre,
                Integer year) {
        this.bookId = bookId;
        this.name = name;
        this.genre = genre;
        this.year = year;
    }

    public UUID getBookId() {
        return bookId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
