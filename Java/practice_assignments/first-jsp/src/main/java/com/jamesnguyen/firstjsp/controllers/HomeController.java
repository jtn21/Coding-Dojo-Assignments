package com.jamesnguyen.firstjsp.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jamesnguyen.firstjsp.models.Assignment;


@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String renderHome(Model model) {
		model.addAttribute("name", "Alex Miller");
		return "home.jsp";
	}
	
	@RequestMapping("/javademo")
	public String renderDemoPage() {
		return "demo.jsp";
	}
	
	@RequestMapping("/jstl")
	public String jstlDemo(Model model) {
		// send variables to jsp
		String name ="Alex Miller";
		Integer age= 28;
		Boolean isHungry = true;
		
		model.addAttribute("jspName", name);
		model.addAttribute("jspAge", age);
		model.addAttribute("jspIsHungry", isHungry);
		// jspName - "Alex Miller"
		//jspAge = 28
		//jspisHungry = true
		
		ArrayList<String> users = new ArrayList<String>();
		users.add("Alex Miller");
		users.add("Martha Smith");
		users.add("Roger Anderson");
		users.add("Steve Roger");
		model.addAttribute("jspUsers", users);
		
		for(String eachUser: users) {
			System.out.println(eachUser);
		}
		
		if(isHungry) {
			System.out.println("I am hungry");
		}
		
		
		return "jstl.jsp";
	}
	
	@RequestMapping("/assignmentLoop")
	public String assignmentLoop(Model model) {
		ArrayList<Assignment> assignmentList = new ArrayList<Assignment>();
		assignmentList.add(new Assignment("Fruity Loop", 7));
		assignmentList.add(new Assignment("CareSoft", 8));
		assignmentList.add(new Assignment("Daikichi Path Variables", 6));
		
		model.addAttribute("assignmentList", assignmentList);
		
		return "assignmentLoop.jsp";
	}
}
