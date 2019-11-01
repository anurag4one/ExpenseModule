/**
 * 
 */
package com.cg.ems.expense.service;

import java.util.List;

import com.cg.ems.expense.dto.Expense;
import com.cg.ems.expense.exception.WrongIDException;

/**
 * @author Anurag Kumar
 * @version 1.0
 *  
 */
public interface ExpenseService {

	Expense addExpense(Expense expense);
	
	List<Expense> displayAllExpense();
	
	Expense displayExpense(int expCode) throws WrongIDException;
	
	//Expense modifyExpense(int expCode, String expType, String expDescription) throws WrongIDException;
	
	Expense modifyExpense(Expense expense) throws WrongIDException;
	
	boolean deleteExpense(int expCode) throws WrongIDException;

}