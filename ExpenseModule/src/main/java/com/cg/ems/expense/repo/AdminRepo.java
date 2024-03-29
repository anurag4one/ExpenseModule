package com.cg.ems.expense.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cg.ems.expense.dto.Admin;

/**
 * @author Anurag Kumar
 * @version 1.0
 * 
 */
public interface AdminRepo extends JpaRepository<Admin, String>{
	
	/**
	 * method with custom query for validating login
	 * @param login
	 * @param password
	 * @return Admin
	 */
	@Query("SELECT a FROM Admin a WHERE a.adminId=:id AND a.adminPassword=:password")
	Admin loginAdmin(String id, String password) ;

//	@Modifying
//	@Query("UPDATE Admin a SET a.adminPassword=:newPassword WHERE a.adminId=:id")
//	int updatePassword(String id, String newPassword);

}