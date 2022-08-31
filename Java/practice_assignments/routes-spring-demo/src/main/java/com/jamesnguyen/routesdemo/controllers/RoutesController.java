package com.jamesnguyen.routesdemo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RoutesController {
	//query parameter: .....search?keyword=whatever&count=5 (after form submission)
	//localhost:8080/search?keyword=whatever ----- ===> keyword <====  in keyword=whatever must match the "" in @requestParam()
	@RequestMapping("/search")
	//whenever we want parameters define in () for searchKeyword
	public String searcKeyword(@RequestParam("keyword")String keywordInMethod) {
		return "You are searching for " + keywordInMethod;
	}
	
	
	//localhost:8080/pet?name=pepper&age=14
	//we use Integer because int cannot be null so it will give errorpage if we use int
	@RequestMapping("/pet")
	public String getPet(@RequestParam("name")String petname, @RequestParam("age")Integer age ) {
		return "Your pet " + petname + " is " + age + "years old";
	}
	
	
	@RequestMapping("/optionalPet")
	public String getOptionalPet(@RequestParam(value="name", required=false)String petname, @RequestParam(value="age", required=false)Integer age ) {
		return "petname and age are not required: " +"Your pet " + petname + " is " + age + "years old";
	}
	
	
	
	
	//path variable: codingdojo.com/m/130/20
	//localhost:8080/path/pepper/white 
	@RequestMapping("/path/{name}/{color}")
	public String pathDemo(@PathVariable("name")String petname, @PathVariable("color")String color ) {
		return petname + " is " + color;
	}
	
	
}
