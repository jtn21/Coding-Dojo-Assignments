package com.jamesnguyen.pm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jamesnguyen.pm.models.Project;
import com.jamesnguyen.pm.models.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {

	
	List<Project> findAll();
	Project findByIdIs(Long id);
	List<Project> findAllByUsers(User user);
	List<Project> findByUsersNotContains(User user);
	
}
