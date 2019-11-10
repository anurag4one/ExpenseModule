/**
 * 
 */
package com.cg.ems.expense.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Anurag Kumar
 * @version 1.0
 */
@Entity
@GenericGenerator(name = "expense_code_seq", strategy = "increment")
@Table(name = "expense")
public class Expense {

	@Id
	@Column(name = "expense_code")
	@GeneratedValue(generator = "expense_code_seq", strategy = GenerationType.SEQUENCE)
	private int expenseCode;

	@Column(name = "expense_type")
	@Pattern(regexp = "[A-Z][a-z]{2,15}")
	@NotBlank(message = "Type is mandatory, cannot be null")
	private String expenseType;

	@Column(name = "expense_description")
	@Pattern(regexp = "[A-Za-z0-9_ ,.]{15,100}")
	@NotBlank(message = "Description is mandatory, cannot be null")
	private String expenseDescription;

	/**
	 * @return the Expense code
	 */
	public int getExpenseCode() {
		return expenseCode;
	}

	/**
	 * @param the Expense code to be set
	 */
	public void setExpenseCode(int expenseCode) {
		this.expenseCode = expenseCode;
	}

	/**
	 * @return the Expense Type
	 */
	public String getExpenseType() {
		return expenseType;
	}

	/**
	 * @param the expense type to be set
	 */
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	/**
	 * @return the Expense Description
	 */
	public String getExpenseDescription() {
		return expenseDescription;
	}

	/**
	 * @param the Expense Description to be set
	 */
	public void setExpenseDescription(String expenseDescription) {
		this.expenseDescription = expenseDescription;
	}
}
