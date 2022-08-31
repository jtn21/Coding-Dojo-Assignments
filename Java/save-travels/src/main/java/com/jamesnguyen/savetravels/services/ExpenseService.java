package com.jamesnguyen.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jamesnguyen.savetravels.models.Expense;
import com.jamesnguyen.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepo;
	
	
	public ExpenseService(ExpenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
	
	// return all expenses
	public List<Expense> allExpenses() {
		return expenseRepo.findAll();
	}

	//create expense
	public Expense createExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	
	//find one
	public Expense oneExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}else {
			return null;
		}
	}
	
	//update one
	public Expense updateExpense( Expense expense) {
		return expenseRepo.save(expense);
	}
	
	//delete one 
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}
	
	
}
