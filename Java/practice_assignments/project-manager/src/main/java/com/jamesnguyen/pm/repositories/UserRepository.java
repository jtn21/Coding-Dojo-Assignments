package com.jamesnguyen.pm.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.jamesnguyen.pm.models.Project;
import com.jamesnguyen.pm.models.User;

public interface UserRepository extends CrudRepository<User,Long> {
	//search for email
	List<User> findAll();
	Optional<User> findByEmail(String email);
	User findByIdIs(Long id);
	List<User> findAllByProjects(Project project);
	List<User> findByProjectsNotContains(Project project);

}
