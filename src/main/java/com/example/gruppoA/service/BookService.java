package com.example.gruppoA.service;

import com.example.gruppoA.dto.BookDto;
import com.example.gruppoA.dto.BookEto;
import com.example.gruppoA.entity.BookEntity;
import com.example.gruppoA.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
@Autowired
    private BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public BookDto addBook(@RequestBody BookDto bookDto){
        BookEntity book= new BookEntity(bookDto);
        bookRepository.save(book);
        return new BookDto(book);
    }
    public List<BookEto> getAll(){
        List<BookEntity> bookEntityList= bookRepository.findAll();
        List<BookEto> bookEtoList=bookEntityList.stream().map(book-> new BookEto(book.getId(),book.getTitle(),book.getAuthor(),book.getIsbn())).toList();
     return bookEtoList;
    }

    public ResponseEntity<?> getById(Long id){
        Optional<BookEntity>optionalBookEntity=bookRepository.findById(id);
        if(optionalBookEntity.isPresent()){
            BookEntity book=optionalBookEntity.get();
            BookDto bookDto=new BookDto(book.getId(),book.getTitle(),book.getAuthor(),book.getIsbn());
            return ResponseEntity.ok(bookDto);
        }
        return ResponseEntity.ok("libro non trovato");
    }
    public BookDto upDateByI(long id, BookDto bookDto){
        bookRepository.deleteById(id);
        BookEntity book =new BookEntity(bookDto);
        bookRepository.save(book);
        return new BookDto(book);
    }

    public void deliteById (Long id){
        bookRepository.deleteById(id);
    }

}
