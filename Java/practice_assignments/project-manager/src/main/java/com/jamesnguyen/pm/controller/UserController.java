package com.jamesnguyen.pm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.jamesnguyen.pm.models.LoginUser;
import com.jamesnguyen.pm.models.Project;
import com.jamesnguyen.pm.models.User;
import com.jamesnguyen.pm.services.ProjectService;
import com.jamesnguyen.pm.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectService projectService;

//--------------------------Login & Registration---------------------------------
	@GetMapping("/")
	public String displayLogReg(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "logregform.jsp";
	}

	@PostMapping("/register")
	public String processRegister(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {
		userService.register(newUser, result);
		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "logregform.jsp";
		}

		session.setAttribute("userId", newUser.getId());
		return "redirect:/projects";
	}
	
	
	@PostMapping("/login")
	public String processLogin(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
	User user = userService.login(newLogin, result);
	
	if(result.hasErrors()) {
		model.addAttribute("newUser", new User());
		return "logregform.jsp";
	}
	
	session.setAttribute("userId", user.getId());
	return "redirect:/projects";
	}
	
	

	
	//-----------------Logout------------------------------------
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//session.etAttriute("userId", null)
		session.invalidate();
		return "redirect:/";
	}
	
	//---------------------Dashboard-----------------------------------------
	@GetMapping("/projects")
	public String allProjects(HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		List<Project> projectList = projectService.allProjects();
		model.addAttribute("projectList", projectList);
		
		
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userService.findbyId(userId));
		
		return "dashboard.jsp";
	}
	
	
	//---------------Create----------------------------------
	@GetMapping("/projects/add")
	public String createProject(@ModelAttribute("project")Project Project, HttpSession session) {
		if(session.getAttribute("userId") ==null) {
			return "redirect:/";
		}
		return "createProject.jsp";
		
	}
	
	//process form
	@PostMapping("/projects/add")
	public String processCreateProject(@Valid @ModelAttribute("project")Project project, BindingResult result) {
		if (result.hasErrors()) {
			return "createProject.jsp";
		}else {
			projectService.createProject(project);
			return "redirect:/projects";
		}
	}
		

	//----------------------Edit--------------------------------------
	
	@GetMapping("/projects/edit/{id}")
	public String editProject(@PathVariable("id")Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") ==null) {
			return "redirect:/";
		}
		model.addAttribute("project", projectService.oneProject(id));
		return "editProject.jsp";
	}
	
	
	//process edit
	@PutMapping("/projects/edit/{id}")
	public String processEditProject(@Valid @ModelAttribute("project")Project project,BindingResult result) {
		if (result.hasErrors()) {
			return "editProject.jsp";
		}else
			projectService.updateProject(project);
			return "redirect:/projects";
	}
	
	//-----------------------Find One--------------------------------------------
	@GetMapping("/projects/{id}")
	public String oneProject(@PathVariable("id")Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") ==null) {
			return "redirect:/";
		}
		model.addAttribute("project", projectService.oneProject(id));
		return "projectDetails.jsp";
	}
	
	
	//------------------------Delete One-------------------------------
	@DeleteMapping("/projects/{id}")
	public String deleteProject(@PathVariable("id")Long id) {
		projectService.deleteProject(id);
		return "redirect:/projects";
		
	}
	
	
	//--------------------------Join tables----------------------------
	
	
	

}
