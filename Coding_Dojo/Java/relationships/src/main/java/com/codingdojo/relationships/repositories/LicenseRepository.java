package com.codingdojo.relationships.repositories;

import java.util.List;

import com.codingdojo.relationships.models.License;

public class LicenseRepository {
	List<License> findAll(); // this method retrieves all the Licenses from the database
	Long countByNameContaining(String search); // this method counts how many License names contain a certain string
	Long deleteByNameStartingWith(String search); // this method deletes an License that starts with a specific string
	List<License> findByNameIs(String name); // this method retrieves a list of Licenses with the given License name
	
	List<License> findByDescriptionContaining(String search); // this method finds Licenses with descriptions containing the search string
}
