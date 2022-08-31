package com.jamesnguyen.savetravels.controllers;

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

import com.jamesnguyen.savetravels.models.Expense;
import com.jamesnguyen.savetravels.services.ExpenseService;

@Controller

public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	

	
	
	//Create
	
	@GetMapping("/expenses")
	public String index(Model model) {
		model.addAttribute("expenseList", expenseService.allExpenses());
		model.addAttribute("expense", new Expense());
		return "index.jsp";
	}


// process form
	
	@PostMapping("/expenses")
	public String processCreate(@Valid @ModelAttribute("expense")Expense expense, BindingResult result, Model model
			) {
		if(result.hasErrors()) {
			model.addAttribute("expenseList", expenseService.allExpenses());
			return "index.jsp";
		}else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	//get one
	@GetMapping("/expenses/{id}")
	public String oneExpense(@PathVariable("id")Long id, Model model) {
		Expense foundExpense = expenseService.oneExpense(id);
		model.addAttribute("oneExpense", foundExpense);
		return "details.jsp";
	}
	
	
	//get one + edit
	@GetMapping("/expenses/edit/{id}")
	public String renderEditForm(@PathVariable("id")Long id, Model model) {
		Expense foundExpense = expenseService.oneExpense(id);
		model.addAttribute("expense" ,foundExpense);
		return "edit.jsp";
	}
	
	
	@PutMapping("/expenses/edit/{id}")
	public String processEdit(@Valid @ModelAttribute("expense")Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			expenseService.updateExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	@DeleteMapping("/expenses/{id}")
	public String processDelete(@PathVariable("id")Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}
	
	
	
	
	
	
	
}
