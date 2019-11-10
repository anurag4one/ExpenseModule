package com.cg.ems.expense.service;

import java.util.List;

import com.cg.ems.expense.dto.Expense;
import com.cg.ems.expense.exception.WrongIDException;
import com.cg.ems.expense.exception.WrongValidationException;

/**
 * @author Anurag Kumar
 * @version 1.0
 */

public interface ExpenseService {

	/**
	 * @param expense
	 * @return Expense
	 * @throws WrongValidationException
	 */
	Expense addExpense(Expense expense) throws WrongValidationException;

	/**
	 * @return all expenses
	 */
	List<Expense> displayAllExpense();

	/**
	 * @param expCode
	 * @return Expense
	 * @throws WrongIDException
	 */
	Expense displayExpense(int expCode) throws WrongIDException;
	
	
	/**
	 * @param expCode
	 * @return true/False boolean
	 * @throws WrongIDException
	 */
	boolean deleteExpense(int expCode) throws WrongIDException;

	List<Integer> displayAllId();

	/**
	 * @param expense
	 * @return 1 for modified/ 0 for not modified
	 * @throws WrongIDException
	 * @throws WrongValidationException
	 */
	int modifyExpense(Expense expense) throws WrongIDException, WrongValidationException;
}