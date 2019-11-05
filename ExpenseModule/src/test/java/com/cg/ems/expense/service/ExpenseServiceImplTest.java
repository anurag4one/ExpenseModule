package com.cg.ems.expense.service;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.ems.expense.dto.Expense;
import com.cg.ems.expense.exception.WrongIDException;

/**
 * @author Anurag
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExpenseServiceImplTest {

	@Autowired
	ExpenseService service;
	
	Expense expense;
	
	@Before
	public void setUp() {
		expense = new Expense();
	}
	
	@After
	public void tearDown() {
		expense = null;
	}
	
	/**
	 * Test method for
	 * {@link com.cg.ems.expense.service.ExpenseServiceImpl#addExpense(com.cg.ems.expense.dto.Expense)}.
	 */
	@Test
	public void testAddExpense() { //successfull
		expense.setExpenseCode(1001);
		expense.setExpenseType("Alfa");
		expense.setExpenseDescription("Something wrong is going on");
		Expense e = service.addExpense(expense);
	}
	
	@Test
	public void testAddExpenseFail() {
		expense.setExpenseType("AlFa");				//violation
		expense.setExpenseDescription("Something wrong is going on");
		service.addExpense(expense);
	}

	/**
	 * Test method for
	 * {@link com.cg.ems.expense.service.ExpenseServiceImpl#displayAllExpense()}.
	 */
	@Test
	public void testDisplayAllExpense() {
		assertNotNull(service.displayAllExpense());
	}

	@Test
	public void testDisplayAllExpenseFail() {
		assertNotNull(service.displayAllExpense());			//only if table is empty
	}
	
	/**
	 * Test method for
	 * {@link com.cg.ems.expense.service.ExpenseServiceImpl#displayExpense(int)}.
	 * @throws WrongIDException 
	 */
	@Test
	public void testDisplayExpense() throws WrongIDException {
		assertNotNull(service.displayExpense(1));
	}
	
	@Test(expected = WrongIDException.class)
	public void testDisplayExpenseExpetion() throws WrongIDException {
		service.displayExpense(3);
	}

	/**
	 * Test method for
	 * {@link com.cg.ems.expense.service.ExpenseServiceImpl#deleteExpense(int)}.
	 */
	@Test
	public void testDeleteExpense() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.cg.ems.expense.service.ExpenseServiceImpl#modifyExpense(int, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testModifyExpense() {
		fail("Not yet implemented");
	}

}
