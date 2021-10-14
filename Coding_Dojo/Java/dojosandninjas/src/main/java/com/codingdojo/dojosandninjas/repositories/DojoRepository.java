package com.codingdojo.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojosandninjas.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> { // Creates a repository that will expose the Spring Data JPA. This will expose a variety of methods, as well as allow us to extend it. <Model, Primary Key (ID) Type>
	List<Dojo> findAll(); // this method retrieves all the dojos from the database
//	Long countByDojoNameContaining(String search); // this method counts how many dojo names contain a certain string
//	Long deleteByDojoNameStartingWith(String search); // this method deletes an dojo that starts with a specific string
//	List<Dojo> findByDojoNameIs(String dojoName); // this method retrieves a list of dojos with the given dojo name
//	
//	List<Dojo> findByDescriptionContaining(String search); // this method finds dojos with descriptions containing the search string
}
