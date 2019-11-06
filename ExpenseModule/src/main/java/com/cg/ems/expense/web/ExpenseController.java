/**
 * 
 */
package com.cg.ems.expense.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.ems.expense.dto.Expense;
import com.cg.ems.expense.exception.WrongIDException;
import com.cg.ems.expense.service.ExpenseService;

/**
 * @author Anurag Kumar
 * @version 1.0
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/expense")
public class ExpenseController {

	@Autowired
	private ExpenseService service;

	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public Expense addNewExpense(@RequestBody Expense expense) {
		return service.addExpense(expense);
	}

	@GetMapping(produces = "application/json")
	public List<Expense> getAllExpenses() {
		return service.displayAllExpense();
	}

	@GetMapping(value = "/allId", produces = "application/json")
	public List<Integer> getAllExpensesId() {
		List<Integer> ids =  service.displayAllId();
		
		return ids;
	}
	
	@GetMapping(value = "/expenseCode/{id}", produces = "application/json")
	public Expense searchByExpenseCode(@PathVariable int id) throws WrongIDException {
		return service.displayExpense(id);
	}

	@DeleteMapping(value = "/delete/{id}", produces = "application/json")
	public boolean removeByExpenseCode(@PathVariable int id) throws WrongIDException {
		return service.deleteExpense(id);
	}
	
//	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
//	public Expense updateExpense(@RequestBody Expense expense) throws WrongIDException {
//		return service.modifyExpense(expense);
//	}
	
	@PutMapping(value = "/update")
	public String updateExpense(@RequestBody Expense expense) throws WrongIDException {
		int temp = service.modifyExpense(expense);
		if(temp == 1)
				return "Successfully modified";
		else
			return "Couldn't modify";
	}
}