package com.project.ExpenseTracker.Service;

import java.util.List;

import com.project.ExpenseTracker.Entity.Expense;

public interface ExpenseServiceInterface {
	List<Expense> findAll();
	void save (Expense expense);
	Expense findById(Long id);
	void delete(Long id);

}
