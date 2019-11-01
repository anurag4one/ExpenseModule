/**
 * 
 */
package com.cg.ems.expense.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.expense.dto.Expense;
import com.cg.ems.expense.exception.WrongIDException;
import com.cg.ems.expense.repo.ExpenseRepo;

/**
 * @author Anurag Kumar
 * @version 1.0
 *
 */

@Service
@Transactional(rollbackOn = WrongIDException.class)
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepo repo;

	@Override
	public Expense addExpense(Expense expense) {
		return repo.save(expense);
	}

	@Override
	public List<Expense> displayAllExpense() {
		return repo.findAll();
	}

	@Override
	public Expense displayExpense(int expCode) throws WrongIDException {
		try {
			return repo.findById(expCode).get();
		} catch (Exception e) {
			throw new WrongIDException("No Expense with Expense Code " + expCode + " found");
		}
	}

	@Override
	public boolean deleteExpense(int expCode) throws WrongIDException {
		try {
			repo.deleteById(expCode);
			return true;
		} catch (Exception e) {
			throw new WrongIDException("No Expense with Expense Code " + expCode + " found");
		}
	}

//	@Override
//	public Expense modifyExpense(int expCode, String expType, String expDescription) throws WrongIDException {
//		try {
//			repo.modifyExpense(expCode, expType, expDescription);
//			return repo.findById(expCode).get();
//		} catch (Exception e) {
//			throw new WrongIDException("No Expense with Expense Code " + expCode + " found");
//		}
//	}

	@Override
	public Expense modifyExpense(Expense expense) throws WrongIDException {
		try {
		return repo.save(expense);
		} catch (Exception e) {
			throw new WrongIDException("No Expense found");
		}
	}
	
}
