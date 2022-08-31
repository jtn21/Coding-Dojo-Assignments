package com.jamesnguyen.routesdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class APIController {

	
	// option 1: RequestMapping default: GET
	@RequestMapping("/option1")
	public String requestMethodOption1() {
		return "Option 1 Request Mapping";
	}
	
	//HTTP VERB: GET/POST/PUT/DELETE
	//option 2: RequestMapping(long way)
	// useful because you just need to change method to whichever action you need
	@RequestMapping(value="/option2", method=RequestMethod.GET)
	public String requestMethodOption2() {
		return "Option 2 Request Mapping";
	}
	
	
	//option 3: GetMapping / PostMapping / PutMapping / DeleteMapping
	@GetMapping("/option3")
	public String requestMethodOption3() {
		return "Option 3 Get Mapping";
	}
	
	
	
}
