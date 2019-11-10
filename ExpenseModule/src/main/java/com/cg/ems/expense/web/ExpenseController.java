package com.cg.ems.expense.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.expense.ExpenseModuleApplication;
import com.cg.ems.expense.dto.Admin;
import com.cg.ems.expense.dto.Expense;
import com.cg.ems.expense.exception.AdminNotFoundException;
import com.cg.ems.expense.exception.WrongIDException;
import com.cg.ems.expense.exception.WrongValidationException;
import com.cg.ems.expense.service.AdminService;
import com.cg.ems.expense.service.ExpenseService;

/**
 * @author admin
 *
 */
/**
 * @author hp
 *
 */
/**
 * @author hp
 *
 */
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:4201", "http://localhost:4206",
		"http://localhost:4615", "http://localhost:4620", "http://localhost:4205" })
@RestController
@RequestMapping("/expense")
public class ExpenseController {

	static Logger myLogger = Logger.getLogger(ExpenseModuleApplication.class);
	
	@Autowired
	private ExpenseService service;

	@Autowired
	private AdminService aService;

	/**
	 * @param expense
	 * @return Expense
	 * @throws WrongValidationException
	 */
	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public Expense addNewExpense(@RequestBody Expense expense) throws WrongValidationException {
		PropertyConfigurator.configure("src/main/resources/Log4j.properties");
		myLogger.info(" Inside add new Expense Controller.");
		try {
			return service.addExpense(expense);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	/**
	 * @return list of expenses
	 */
	@GetMapping(produces = "application/json")
	public List<Expense> getAllExpenses() {
		PropertyConfigurator.configure("src/main/resources/Log4j.properties");
		myLogger.info(" Inside Get All Expense Controller.");
		return service.displayAllExpense();
	}

	/**
	 * @return list of expense ids present
	 */
	@GetMapping(value = "/allId", produces = "application/json")
	public List<Integer> getAllExpensesId() {
		PropertyConfigurator.configure("src/main/resources/Log4j.properties");
		myLogger.info(" Inside Get All Expense ids Controller.");
		List<Integer> ids = service.displayAllId();
		return ids;
	}

	
	/**
	 * @param id
	 * @return expense
	 * @throws WrongIDException
	 */
	@GetMapping(value = "/expenseCode/{id}", produces = "application/json")
	public Expense searchByExpenseCode(@PathVariable int id) throws WrongIDException {
		PropertyConfigurator.configure("src/main/resources/Log4j.properties");
		myLogger.info(" Inside Search by Expense code Controller.");
		return service.displayExpense(id);
	}

	/**
	 * @param id
	 * @return boolean
	 * @throws WrongIDException
	 */
	@DeleteMapping(value = "/delete/{id}", produces = "application/json")
	public boolean removeByExpenseCode(@PathVariable int id) throws WrongIDException {
		PropertyConfigurator.configure("src/main/resources/Log4j.properties");
		myLogger.info(" Inside Remove Expense Controller.");
		return service.deleteExpense(id);
	}

	/**
	 * @param expense
	 * @return message for update or not.
	 * @throws WrongIDException
	 * @throws WrongValidationException
	 */
	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public String updateExpense(@RequestBody Expense expense) throws WrongIDException, WrongValidationException {
		PropertyConfigurator.configure("src/main/resources/Log4j.properties");
		myLogger.info(" Inside Update Expense Controller.");
		int temp = service.modifyExpense(expense);
		if (temp == 1) {
			myLogger.info(" Successfully updated.");
			return "Successfully modified";
		} else
			return "Couldn't modify";
	}

	/**
	 * @param id
	 * @param password
	 * @return Admin
	 */
	@GetMapping(value = "/login/{id}/{password}", produces = "application/json")
	public Admin loginAdmin(@PathVariable("id") String id, @PathVariable("password") String password) {
		PropertyConfigurator.configure("src/main/resources/Log4j.properties");
		myLogger.info(" Inside Login Controller.");
		try {
			myLogger.info(" logged in successfully.");
			return aService.login(id, password);
		} catch (AdminNotFoundException ex) {
			myLogger.info(" couldn't logged in successfully.");
			System.out.println(ex.getMessage());
			return null;
		}
	}
//
//	@PutMapping(value = "/updatePassword")
//	public String updateAdmin(@RequestParam("id") String id, @RequestParam("oldPassword") String oldPassword,
//			@RequestParam("newPassword") String newPassword) {
//		// logger.info("Trying for Login");
//		try {
//			// logger.info("Successful Employee login");
//			if (aService.updatePassword(id, oldPassword, newPassword) == 1) {
//				System.out.println("Successfully updated password");
//				return "Successfully updated password";
//			} else
//				return "couldn't update";
//		} catch (AdminNotFoundException ex) {
//			// logger.error("Employees login not successful ");
//			return ex.getMessage();
//		}
	// }
}