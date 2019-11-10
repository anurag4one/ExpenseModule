/**
 * 
 */
package com.cg.ems.expense.service;

import com.cg.ems.expense.dto.Admin;
import com.cg.ems.expense.exception.AdminNotFoundException;

/**
 * @author Anurag Kumar
 * @version 1.0
 *
 */
public interface AdminService {

	/**
	 * @param id
	 * @param password
	 * @return Admin
	 * @throws AdminNotFoundException
	 */
	Admin login(String id, String password) throws AdminNotFoundException;

	//int updatePassword(String id, String oldPassword, String newPassword) throws AdminNotFoundException;
}