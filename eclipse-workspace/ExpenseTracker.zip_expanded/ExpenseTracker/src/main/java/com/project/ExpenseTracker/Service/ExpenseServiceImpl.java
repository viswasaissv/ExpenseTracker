package com.project.ExpenseTracker.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ExpenseTracker.Entity.Expense;
import com.project.ExpenseTracker.Repository.ExpenseRepository;
@Service
public class ExpenseServiceImpl implements ExpenseServiceInterface {
	@Autowired
	ExpenseRepository expenserepo;
	

	@Override
	public List<Expense> findAll() {
		
		return expenserepo.findAll();
	}


	@Override
	public void save(Expense expense) {
		expense.setCreatedAt(System.currentTimeMillis());
		expenserepo.save(expense);
		// TODO Auto-generated method stub
		
	}


	@Override
	public Expense findById(Long id) {
		if(expenserepo.findById(id).isPresent()) {
			return expenserepo.findById(id).get();
		}
		return null;
	}


	@Override
	public void delete(Long id) {
		if(expenserepo.findById(id).isPresent())
		{
			expenserepo.deleteById(id);
		}
		// TODO Auto-generated method stub
		
	}

}
