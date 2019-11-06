package com.cg.ems.expense.service;

import java.util.ArrayList;
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

		List<Expense> displayAll = repo.findAll();

		return displayAll;
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

	@Override
	public int modifyExpense(Expense expense) throws WrongIDException {
		int expCode = expense.getExpenseCode();
		String expType = expense.getExpenseType();
		String expDescription = expense.getExpenseDescription();
		try {
			return repo.modifyExpense(expCode, expType, expDescription);
		} catch (Exception e) {
			throw new WrongIDException("Expense wtih code " + expCode + " not found");
		}
	}

	@Override
	public List<Integer> displayAllId() {
		List<Integer> expId = new ArrayList<Integer>();
		List<Expense> displayAll = repo.findAll();

		for (Expense exp : displayAll) {
			expId.add(exp.getExpenseCode());
			//System.out.println(exp.getExpenseCode());
		}

		return expId;
	}
}