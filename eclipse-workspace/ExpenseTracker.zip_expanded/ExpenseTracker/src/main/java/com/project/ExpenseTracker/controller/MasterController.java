package com.project.ExpenseTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.ExpenseTracker.Entity.Expense;
import com.project.ExpenseTracker.Service.ExpenseServiceInterface;

@Controller
public class MasterController {
	@Autowired
	ExpenseServiceInterface expenseService;
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("message","list of expenses");
		List<Expense> expenselist=expenseService.findAll();
		mv.addObject("expenses",expenselist);
		return mv;
	}
	
	@RequestMapping("/expense")
	public ModelAndView addexpense() {
		ModelAndView mv=new ModelAndView("expense");
		mv.addObject("expense",new Expense());
		return mv;
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@ModelAttribute("expense") Expense expense)
	{
		expenseService.save(expense);
		return "redirect:/";
	}
	
	@RequestMapping(value="expense/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mv= new ModelAndView("expense");
		Expense expense=expenseService.findById(id);
		mv.addObject("expense",expense);
		return mv;
	}
	
	@RequestMapping(value="expense/{id}/delete")
	public String delete(@PathVariable("id") Long id)
	{
		expenseService.delete(id);
		return "redirect:/";
		
	}

}
