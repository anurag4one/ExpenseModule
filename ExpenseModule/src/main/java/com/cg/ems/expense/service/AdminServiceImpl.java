/**
 * 
 */
package com.cg.ems.expense.service;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.expense.ExpenseModuleApplication;
import com.cg.ems.expense.dto.Admin;
import com.cg.ems.expense.exception.AdminNotFoundException;
import com.cg.ems.expense.repo.AdminRepo;

/**
 * @author Anurag Kumar
 * @version 1.0
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	static Logger myLogger = Logger.getLogger(ExpenseModuleApplication.class);

	@Autowired
	private AdminRepo aRepo;

	/**
	 * overridden method of Admin service interface, used for login.
	 */
	@Override
	public Admin login(String id, String password) throws AdminNotFoundException {
		Admin admin = aRepo.loginAdmin(id, password);
		PropertyConfigurator.configure("src/main/resources/Log4j.properties");
		myLogger.info(" Inside login Admin Service.");
		if (admin != null) {
			return admin;
		} else
			throw new AdminNotFoundException("Wrong credentials");
	}

//	@Override
//	public int updatePassword(String id, String oldPassword, String newPassword) throws AdminNotFoundException {
//
//		Admin admin = aRepo.loginAdmin(id, oldPassword);
//		if (admin != null)
//			return aRepo.updatePassword(id, newPassword);
//		else
//			throw new AdminNotFoundException("Wrong credentials");
//	}
}
