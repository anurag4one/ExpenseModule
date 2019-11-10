/**
 * 
 */
package com.cg.ems.expense.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.expense.ExpenseModuleApplication;
import com.cg.ems.expense.dto.Expense;
import com.cg.ems.expense.exception.WrongIDException;
import com.cg.ems.expense.exception.WrongValidationException;
import com.cg.ems.expense.repo.ExpenseRepo;

/**
 * @author Anurag Kumar
 * @version 1.0
 */
@Service
@Transactional(rollbackOn = { WrongIDException.class, WrongValidationException.class })
public class ExpenseServiceImpl implements ExpenseService {

	static Logger myLogger = Logger.getLogger(ExpenseModuleApplication.class);

	@Autowired
	private ExpenseRepo repo;

	/**
	 * overridden method for adding an expense
	 */
	@Override
	public Expense addExpense(Expense expense) throws WrongValidationException {

		PropertyConfigurator.configure("src/main/resources/Log4j.properties");
		myLogger.info(" Inside add new Expense Service.");

		Expense expenseLocal = repo.save(expense);
		if (expenseLocal != null) {
			myLogger.info(" Expense Service added an expense.");
			return expenseLocal;
		} else
			throw new WrongValidationException("Input in wrong format");
	}

	/**
	 * Overridden method for displaying all expenses
	 */
	@Override
	public List<Expense> displayAllExpense() {
		PropertyConfigurator.configure("src/main/resources/Log4j.properties");
		myLogger.info(" Inside display all Expense Service.");

		List<Expense> displayAll = repo.findAll();
		return displayAll;
	}

	/**
	 * Overridden method for displaying an expense
	 */
	@Override
	public Expense displayExpense(int expCode) throws WrongIDException {

		PropertyConfigurator.configure("src/main/resources/Log4j.properties");
		myLogger.info(" Inside Search an Expense Service.");

		Expense expenseLocal = repo.findById(expCode).get();

		if (expenseLocal != null) {
			myLogger.info(" Search an Expense Service completed.");
			return expenseLocal;
		} else
			throw new WrongIDException("No Expense with Expense Code " + expCode + " found");
	}

	/**
	 * overridden method for deleting a method
	 */
	@Override
	public boolean deleteExpense(int expCode) throws WrongIDException {
		PropertyConfigurator.configure("src/main/resources/Log4j.properties");
		myLogger.info(" Inside Search an Expense Service.");
		try {
			repo.deleteById(expCode);
			myLogger.info(" Deleted successful in service.");
			return true;
		} catch (Exception e) {
			myLogger.info("Couldn't delete");
			throw new WrongIDException("No Expense with Expense Code " + expCode + " found");
		}
	}

	@Override
	public List<Integer> displayAllId() {

		List<Integer> expId = new ArrayList<Integer>();
		List<Expense> displayAll = repo.findAll();

		for (Expense exp : displayAll) {
			expId.add(exp.getExpenseCode());
		}
		return expId;
	}


	/**
	 * overridden method for modifying expense
	 */
	@Override
	public int modifyExpense(Expense expense) throws WrongIDException, WrongValidationException {
		int expCode = expense.getExpenseCode();
		String expType = expense.getExpenseType();
		String expDescription = expense.getExpenseDescription();

		PropertyConfigurator.configure("src/main/resources/Log4j.properties");
		myLogger.info(" Inside Modify an Expense Service.");

		if (repo.findById(expCode) != null) {
			int expenseLocal = repo.modifyExpense(expCode, expType, expDescription);

			PropertyConfigurator.configure("src/main/resources/Log4j.properties");
			myLogger.info(" Search for Expense to be modified successfull.");

			if (expenseLocal != 0) {

				myLogger.info(" Modified.");
				return expenseLocal;
			} else {

				myLogger.info(" Couldn't modify.");
				throw new WrongValidationException("Input in wrong format");
			}
		} else {
			
			myLogger.info(" Couldn't find the expense to be modified.");
			throw new WrongIDException("Expense with code " + expCode + " not found");
		}
	}
}