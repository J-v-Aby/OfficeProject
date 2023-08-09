package com.example.gruppoA.dto;

import com.example.gruppoA.entity.BookEntity;

public class BookDto {
    private Long id;
    private  String title;
    private String author;
    private  String isbn;

    public BookDto(BookEntity book) {
        this.id = book.getId();
        this.title =book.getTitle();
        this.author = book.getAuthor();
        this.isbn = book.getIsbn();
    }

    public BookDto(Long id, String title, String author, String isbn) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
