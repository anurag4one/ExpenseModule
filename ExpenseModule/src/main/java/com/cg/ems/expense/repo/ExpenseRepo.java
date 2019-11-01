/**
 * 
 */
package com.cg.ems.expense.repo;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.cg.ems.expense.dto.Expense;

/**
 * @author Anurag Kumar
 * @version 1.0
 * 
 */
public interface ExpenseRepo extends JpaRepository <Expense, Integer> {

//	@Query("UPDATE Expense SET expense_type =:eT, expense_description =:eD WHERE expense_code =:eC")
//	void modifyExpense(int eC, String eT, String eD); 	
}