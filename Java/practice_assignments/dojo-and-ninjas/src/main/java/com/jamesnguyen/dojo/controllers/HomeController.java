package com.jamesnguyen.dojo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jamesnguyen.dojo.models.Dojo;
import com.jamesnguyen.dojo.models.Ninja;
import com.jamesnguyen.dojo.services.DojoService;
import com.jamesnguyen.dojo.services.NinjaService;

@Controller
public class HomeController {
	
	
	//import both services
	
	@Autowired
	private DojoService dojoService;
	 
	@Autowired
	private NinjaService ninjaService;
	
	
//	@GetMapping("/dojos/{id}")
//	public String ninjaIndex( Model model, @PathVariable("id") Long id) {
//		model.addAttribute("dojo", dojoService.oneDojo(id));
//		return "details.jsp";
//	}
	
	@GetMapping("/dojos/{id}")
	public String testName(@PathVariable("id")Long id, Model model) {
		model.addAttribute("dojo", dojoService.oneDojo(id));
		return "details.jsp";
	}
	
	
	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("dojoList", dojoService.allDojos());
		return "dashboard.jsp";
	}
	
	
	//==================CREATE=================================
	@GetMapping("/add/dojos")
	public String renderDojoForm(@ModelAttribute("dojo")Dojo dojo) {
		return "createDojo.jsp";
	}
	

	//process form 
	// route needs to match route on form
	@PostMapping("/add/dojos")
	public String processDojoform(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "createDojo.jsp";
		}
		dojoService.saveDojo(dojo);
		return "redirect:/";
	}
	
	//==================Create=====================
	@GetMapping("/add/ninjas")
	public String renderNinjaForm(@ModelAttribute("ninja")Ninja ninja, Model model) {
		List<Dojo> dojoList = dojoService.allDojos();
		model.addAttribute("dojoList", dojoList);
		return "createNinja.jsp";
	}
	
	
	//Process ninja form
	@PostMapping("/add/ninjas")
	public String processNinjaform(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			// add the list so it does not disappear
			List<Dojo> dojoList = dojoService.allDojos();
			model.addAttribute("dojoList", dojoList);
			return "createNinja.jsp";
		}
		ninjaService.saveNinja(ninja);
		return "redirect:/";
	}
	

	
}
