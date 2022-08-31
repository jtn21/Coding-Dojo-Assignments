package com.jamesnguyen.login.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.jamesnguyen.login.models.User;

public interface UserRepository extends CrudRepository<User,Long> {
	// search for email
	Optional<User>findByEmail(String email);
}
