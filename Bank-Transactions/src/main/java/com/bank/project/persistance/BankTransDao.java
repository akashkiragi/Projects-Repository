package com.bank.project.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bank.project.models.BankAccount;

public interface BankTransDao extends JpaRepository<BankAccount, String>{
		
	@Query(value = "select * from bank_account where account_num = :account_num", nativeQuery = true)
	BankAccount findByAccountNum(@Param("account_num") long accountNum);
}
