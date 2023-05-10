package com.yezza.nadhir.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yezza.nadhir.models.Expense;
import com.yezza.nadhir.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	public List<Expense> allExpenses(){
		return expenseRepository.findAll();
	}
	
	public Expense createExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}else {
			return null;
		}
	}
	
	public Expense updateExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	public void deleteExpense(Expense expense) {
		expenseRepository.delete(expense);
	}

}