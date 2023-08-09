package com.example.gruppoA.controller;

import com.example.gruppoA.dto.BookDto;
import com.example.gruppoA.dto.BookEto;
import com.example.gruppoA.repository.BookRepository;
import com.example.gruppoA.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping("/salva")
    public BookDto bookDto(@RequestBody BookDto bookDto){
        return  bookService.addBook(bookDto);
    }
    @GetMapping("/lista")
    public List<BookEto>findAll(){ return bookService.getAll();}
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return bookService.getById(id);
    }
    @PutMapping("/{id}")
    public BookDto updateBook(@PathVariable Long id,@RequestBody BookDto bookDto){
        return bookService.upDateByI(id,bookDto);
    }
    public ResponseEntity <?> delite(@PathVariable Long id){
        bookService.deliteById(id);
        return ResponseEntity.ok("delite");
    }
}
