package com.jamesnguyen.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/omikuji")
public class HomeController {
	
	
	//renders form
	@GetMapping("")
		public String renderHome(Model model) {
			return "omikuji.jsp";
		}
	
	
	
	// process the form
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String processOmikuji(
			@RequestParam("number") Integer number,
			@RequestParam("city") String city,
			@RequestParam("person") String person, 
			@RequestParam("hobby") String hobby,
			@RequestParam("livingThing") String livingThing,
			@RequestParam("comments") String comments,
			HttpSession session
			) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("livingThing", livingThing);
		session.setAttribute("comments", comments);
		
		return "redirect:/omikuji/show";
	}
	
	
	//render display of results
	@GetMapping("/show")
		public String renderShow() {
		return "show.jsp";
	}

	
	
}
