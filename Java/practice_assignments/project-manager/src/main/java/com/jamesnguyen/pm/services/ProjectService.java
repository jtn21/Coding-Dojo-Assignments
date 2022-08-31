package com.jamesnguyen.pm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamesnguyen.pm.models.Project;
import com.jamesnguyen.pm.models.User;
import com.jamesnguyen.pm.repositories.ProjectRepository;

@Service
public class ProjectService {

	
	@Autowired
	private ProjectRepository projectRepo;
	
	//find all
	public List<Project> allProjects(){
		return projectRepo.findAll();
	}
	
	
	
	//find one
	public Project oneProject(Long id) {
		Optional<Project> optionalProject = projectRepo.findById(id);
		if(optionalProject.isPresent()) {
			return optionalProject.get();
		}else {
			return null;
		}
	}
	
	
	//create 
	
	public Project createProject(Project project) {
		return projectRepo.save(project);
	}
	
	
	//update
	public Project updateProject(Project project) {
		return projectRepo.save(project);
	}
	
	//delete
	public void deleteProject(Long id) {
		projectRepo.deleteById(id);
	}
	
	
	//find all joined projects
	public List<Project> findJoinedProjects(User user){
		return projectRepo.findAllByUsers(user);
	}
	
	
	//------------------find projects with no users-------------
	public List<Project> findUnjoinedProject(User user){
		return projectRepo.findByUsersNotContains(user);
	}
	
	
	
	
	
	
	
	
	
}
