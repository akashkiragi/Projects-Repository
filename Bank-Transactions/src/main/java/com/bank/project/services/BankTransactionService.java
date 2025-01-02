package com.bank.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bank.project.exception.AccountHandleException;
import com.bank.project.models.BankAccount;
import com.bank.project.persistance.BankTransDao;

@Service
public class BankTransactionService {

	@Autowired
	BankTransDao bankDao;
	
	
	@Value("${app.bank.account.length}")
	private int accountNumLen;
	
	
	private static final String CREDIT = "CREDIT";
	
	
	private static final String  DEBIT = "DEBIT";
	
	
	public Optional<BankAccount> createBankAccount(BankAccount bankAccount) {
		if(Optional.ofNullable(bankAccount.getBalance()).isEmpty())  bankAccount.setBalance(0);
		long accNum = bankAccount.getAccountNum();
		int length = Long.toString(Math.abs(accNum)).length();
		if(length != accountNumLen) {
			throw new AccountHandleException("Failed to create accont as The length of the account Number should be 12", HttpStatus.NOT_ACCEPTABLE);
		}
		Optional<BankAccount> newAccount;
		
		try {
			newAccount = Optional.ofNullable(bankDao.save(bankAccount));
		} catch (Exception e) {		
			throw new AccountHandleException("Failed to create accont", HttpStatus.INTERNAL_SERVER_ERROR);
		}			
		
		return newAccount;
	}
	
	public BankAccount getAccountBayAccountNum( long accountNum) {
		Optional<BankAccount> account= Optional.ofNullable(bankDao.findByAccountNum(accountNum));
		if(account.isEmpty()) {
			throw new AccountHandleException("No Account found for the given account Number " + accountNum, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return bankDao.findByAccountNum(accountNum);
	}
	
	public List<BankAccount> getAccounts() {		
		return bankDao.findAll();
	}

	
	public void updateTheBankAccount(BankAccount bankAccount, String type) {
		long accountNum = bankAccount.getAccountNum();
		double amount = bankAccount.getBalance();
		BankAccount updaetedBank = getAccountBayAccountNum(accountNum);
		double balance = updaetedBank.getBalance();
		
		if(type.equalsIgnoreCase(DEBIT)) {
			updaetedBank.setBalance(balance - amount);
		}else if(type.equalsIgnoreCase(CREDIT)){
			updaetedBank.setBalance(balance + amount);
		}
		
		bankDao.save(updaetedBank);
	}
	
}