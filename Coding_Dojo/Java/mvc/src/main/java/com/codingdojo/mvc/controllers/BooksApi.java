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
    private final BookService bookService; // tells us that we are going to be using a bookService and that it will not be changing
    public BooksApi(BookService bookService){ // dependency injection; makes bookService available in our controller
        this.bookService = bookService;
    }
    @GetMapping("/api/books")
    public List<Book> index() {
        return bookService.allBooks();
    }
    
    @PostMapping("/api/books")
    public Book create(
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang, 
    		@RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }
    
    @GetMapping("/api/books/{id}")
    public Book show(
    		@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        return book;
        

    @PutMapping("/api/books/{id}")
    public Book update(
        		@PathVariable("id") Long id, 
        		@RequestParam(value="title") String title, 
        		@RequestParam(value="description") String desc, 
        		@RequestParam(value="language") String lang,
        		@RequestParam(value="pages") Integer numOfPages) {
            Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
            return book;
        }
    
    @DeleteMapping("/api/books/{id}")
    public void destroy(@PathVariable("id") Long id) {
            bookService.deleteBook(id);
    }
}