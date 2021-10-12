package com.codingdojo.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> { // Creates a repository that will expose the Spring Data JPA. This will expose a variety of methods, as well as allow us to extend it. <Model, Primary Key (ID) Type>
    List<Book> findAll(); // this method retrieves all the books from the database
    List<Book> findByDescriptionContaining(String search); // this method finds books with descriptions containing the search string
    Long countByTitleContaining(String search); // this method counts how many titles contain a certain string
    Long deleteByTitleStartingWith(String search); // this method deletes a book that starts with a specific title
    
    List<Book> findByTitleIs(String title); // this method retrieves a list of books with the given title 
}
