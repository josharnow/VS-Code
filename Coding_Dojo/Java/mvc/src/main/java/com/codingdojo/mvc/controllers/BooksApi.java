package com.codingdojo.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

@RestController
public class BooksApi {
    private final BookService service; // tells us that we are going to be using a bookService and that it will not be changing
    public BooksApi(BookService service){ // dependency injection; makes bookService available in our controller
        this.service = service;
    }
    @GetMapping("/api/books")
    public List<Book> index() {
        return service.allBooks();
    }
    
    @PostMapping("/api/books")
    public Book create(
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang, 
    		@RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        return service.createBook(book);
    }
    
    @GetMapping("/api/books/{id}")
    public Book show(
    		@PathVariable("id") Long id) {
        Book book = service.findBook(id);
        return book;
    }
        

    @PutMapping("/api/books/{id}") // Because this is a put request, it is not expecting to get RequestParams below in the URL itself, but rather sends them through the body of the request
    public Book update(
        		@PathVariable("id") Long id, 
        		@RequestParam(value="title") String title, 
        		@RequestParam(value="description") String description, 
        		@RequestParam(value="language") String lang,
        		@RequestParam(value="pages") Integer numOfPages) {
            Book book = service.updateBook(id, title, description, lang, numOfPages);
            
          //  Book book = new Book(id, title, description, lang, numOfPages);
            
            return book;
        }
    
    @DeleteMapping("/api/books/{id}")
    public void destroy(@PathVariable("id") Long id) {
            service.deleteBook(id);
    }
}