package com.jamesnguyen.passignment.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/daikichi")
public class RoutesController {
	
	
	@GetMapping("")
	public String message() {
		return "Welcome!";
	}
	
	
	@GetMapping("/today")
	public String message2() {
		return "Today you will find luck in all your endeavors";
	}
	
	@GetMapping("/tomorrow")
	public String message3() {
		return "Tomorrow an opportunity will arise so be sure to be open to new ideas!";
	}
	
	
	@GetMapping("/travel/{destination}")
	public String daikichiTravel(@PathVariable("destination")String destination) {
		return "Congratulations! You will soon travel to " + destination;
	}
	
	@GetMapping("/{activity}/{duration}")
	public String daikichiActivity(@PathVariable("activity")String activity, @PathVariable("duration")Integer duration) {
		return "You will " + activity + " for " + duration + " minutes today ";
	}
	
	@GetMapping("/lotto/{number}")
	public String daikichiLotto(@PathVariable("number")Integer number) {
		if(number % 2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		}else {
			return "You have enjoyed the fruits of your labor but now it is a great time to spend time with family and friends";
		}
	}
	
}
