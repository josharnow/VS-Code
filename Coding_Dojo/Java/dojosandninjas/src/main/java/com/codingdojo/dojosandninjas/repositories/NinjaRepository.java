package com.codingdojo.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojosandninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> { // Creates a repository that will expose the Spring Data JPA. This will expose a variety of methods, as well as allow us to extend it. <Model, Primary Key (ID) Type>
	List<Ninja> findAll();
//	Long countByNinjaNameContaining(String search);
//	Long deleteByNinjaNameStartingWith(String search);
//	List<Ninja> findByNinjaNameIs(String dojoName);
//	
//	List<Ninja> findByDescriptionContaining(String search);
}
