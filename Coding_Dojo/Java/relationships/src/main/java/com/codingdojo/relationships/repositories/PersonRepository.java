package com.codingdojo.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.relationships.models.Person;

@Repository
public interface PersonRepository  extends CrudRepository<Person, Long> {
	List<Person> findAll(); // this method retrieves all the persons from the database
	Long countByNameContaining(String search); // this method counts how many person names contain a certain string
	Long deleteByNameStartingWith(String search); // this method deletes an person that starts with a specific string
	List<Person> findByNameIs(String name); // this method retrieves a list of persons with the given person name
	
	List<Person> findByDescriptionContaining(String search); // this method finds persons with descriptions containing the search string
}
