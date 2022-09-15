package com.project.ExpenseTracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ExpenseTracker.Entity.Expense;
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{

}
