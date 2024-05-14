package com.bank.project.resource;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.project.models.BankAccount;
import com.bank.project.services.BankTransactionService;

@RestController
@RequestMapping("/api/bank-acounts")
public class DataResources {
	
	@Autowired
	BankTransactionService bankTrans;
	
	@GetMapping("/accounts/{accountNumber}")
	public BankAccount getAccount(@PathVariable("accountNumber") long  accountNumber) {
		
		return bankTrans.getAccountBayAccountNum(accountNumber);
		
	}
	
	
	@PostMapping("/NewAccount")
	public String createNewAccount(@RequestBody BankAccount bankAccount ) {
		try {
			return bankTrans.createBankAccount(bankAccount);
		}catch(SQLException sqlException ){
			return "Failed To create the Account:::"+ sqlException.getErrorCode() +"   "+sqlException.getMessage();
		} catch (Exception e) {
			return "Failed To create the Account:::"+ e.getMessage();
		}
		
	}
	@PostMapping("/update-account/{type}")
	public String createNewAccount(@RequestBody BankAccount bankAccount, @PathVariable("type") String type ){
		bankTrans.updateTheBankAccount(bankAccount, type);
		return "Updaetd";
	}
	
	

	
}
