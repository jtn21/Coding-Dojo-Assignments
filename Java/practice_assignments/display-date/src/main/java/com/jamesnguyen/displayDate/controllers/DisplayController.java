package com.jamesnguyen.displayDate.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class DisplayController {
	@RequestMapping("/")
	public String dashboard() {
		return ("");
	}

}
