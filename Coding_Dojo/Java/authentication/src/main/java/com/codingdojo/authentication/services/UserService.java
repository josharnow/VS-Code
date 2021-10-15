package com.codingdojo.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.authentication.models.LoginUser;
import com.codingdojo.authentication.models.User;
import com.codingdojo.authentication.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    // REGISTRATION
    public User register(User newUser, BindingResult result) {
        if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
            result.rejectValue("email", "Unique", "This email is already in use!");
        }
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepo.save(newUser);
        }
    }
    // LOGIN
    public User login(LoginUser newLogin, BindingResult result) {
        if(result.hasErrors()) {
            return null;
        }
        Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
        if(!potentialUser.isPresent()) {
            result.rejectValue("email", "Unique", "Unknown email!");
            return null;
        }
        User user = potentialUser.get();
        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            return user;
        }
    }
    
	// Method to find one User by ID
	public User findById(
			Long id) { // retrieves a User
		Optional<User> optionalUser = userRepo.findById(id); // returns an optional object that may or may not contain (hence, Optional) our book object
		if(optionalUser.isPresent()) { // checks if our object exists
			return optionalUser.get(); // if the object exists, we return our book object by calling the get() method
		} else {
			return null; // if the object does not exists, returns null.
		}
	}
	
	//	 public Dojo updateDojo( // updates a Dojo
	//		Long id, 
	//		String name, 
	//		String vendor, 
	//		Double cost,
	//		String description) {
	//	Dojo dojo = this.findDojo(id);
	//
	//// 	dojo.setName(name);
	//// 	dojo.setVendor(vendor);
	//// 	dojo.setCost(cost);
	//// 	dojo.setDescription(description);
	//
	//// 	return repo.save(dojo);
	//}
	
	// Method to update a User
	public User update( // updates a User
	 		User user) {
	 return userRepo.save(user);
	}
	
	// Method to delete a User
	public void destroyUser(
		Long id) {// deletes an User
	userRepo.deleteById(id);
	}
}

// Our service is the perfect place to stash some code to run some extra validations and ensure the password is hashed.