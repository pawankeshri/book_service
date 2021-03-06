package com.pk.demo.services.book_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.pk.demo.services.book_service.entity.Book;
import com.pk.demo.services.book_service.exception.RecordNotFoundException;
import com.pk.demo.services.book_service.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
    BookService bookservice;
	
	@CrossOrigin
	@GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> list = bookservice.getAllBooks();
 
        return new ResponseEntity<List<Book>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @CrossOrigin	
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
    	Book entity = bookservice.getBookById(id);
 
        return new ResponseEntity<Book>(entity, new HttpHeaders(), HttpStatus.OK);
    }
    
    @CrossOrigin
    @PostMapping
    public ResponseEntity<Book> createOrUpdateBook(@RequestBody Book book)
                                                    throws RecordNotFoundException {
    	Book updated = bookservice.createOrUpdateBook(book);
        return new ResponseEntity<Book>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @CrossOrigin
    @DeleteMapping("/{id}")
    public HttpStatus deleteBookById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
    	bookservice.deleteBookById(id);
        return HttpStatus.FORBIDDEN;
    }
 }
