package com.example.gruppoA.entity;

import com.example.gruppoA.dto.BookDto;
import jakarta.persistence.*;

@Entity
@Table(name ="book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column
    private  String title;
    @Column
    private  String author;
    @Column
    private String isbn;
    public BookEntity(BookDto bookDto) {
        this.id = bookDto.getId();
        this.title = bookDto.getTitle();
        this.author = bookDto.getAuthor();
        this.isbn=bookDto.getIsbn();
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
