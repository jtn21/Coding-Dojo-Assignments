package com.jamesnguyen.pm.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.jamesnguyen.pm.models.LoginUser;
import com.jamesnguyen.pm.models.Project;
import com.jamesnguyen.pm.models.User;
import com.jamesnguyen.pm.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	
	//-----------------------------Register----------------------------------------
	
    public User register(User newUser, BindingResult result) {
        // TO-DO - Reject values:

        // Reject if email is taken (present in database)
    	// 1. Find user in the DB by email
    	Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());

    	// 2. if the email is present , reject
    	if(optionalUser.isPresent()) { // if the user is present, return true
    		result.rejectValue("email", "unique", "This email is already in the database");
    	}    	   	

        // Reject if password doesn't match confirmation
    	if(!newUser.getPassword().equals(newUser.getConfirm())) { // if(!a.equals(b)) --> a!= b
    		result.rejectValue("confirm", "matches", "The confirm password does not match");
    	}

        // Return null if result has errors
    	if(result.hasErrors()) {
    		return null;
    	}

        // Hash and set password, save user to database
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	return userRepo.save(newUser);
    }
    
    
//--------------------------------Login------------------------------------------------------------    

    
    public User login(LoginUser newLoginObject, BindingResult result) {
    	
    	Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
    	
    	if(!potentialUser.isPresent()) {
    		result.rejectValue("email", "unique", "The email is not registered");
    		return null;
    	}
    	
    	User user = potentialUser.get();
    	
    	if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
    		result.rejectValue("password", "Matches", "Invalid password");
    	}
    	
    	if(result.hasErrors()) {
    		return null;
    	}
    	
    	return user;
    	
    }
    
    
    public User findbyId(Long id) {

    	Optional<User> potentialUser = userRepo.findById(id);
    	if(potentialUser.isPresent()) {
    		return potentialUser.get();
    	}
    	return null;
    }
    
    //-------------finds users not in a project----------------------
    public List<User> findUserNotInProject(Project project){
    	return userRepo.findByProjectsNotContains(project);
  
    }
    
    
    //----------------find users in a project
    public List<User> findAllUsersInProjects(Project project){
    	return userRepo.findAllByProjects(project);
    }
	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
