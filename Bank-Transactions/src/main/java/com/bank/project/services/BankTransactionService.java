package com.bank.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bank.project.models.BankAccount;
import com.bank.project.persistance.BankTransDao;

@Service
@Component
public class BankTransactionService {

	@Autowired
	BankTransDao bankDao;
	
	
	@Value("${app.bank.account.length}")
	private int accountNumLen;
	
	@Value("${app.bank.trans.credit}")
	private String credit;
	
	@Value("${app.bank.trans.debit}")
	private String  DEBIT;
	
	
	public String createBankAccount(BankAccount bankAccount) throws Exception{
		bankAccount.setBalance(0);
		long accNum = bankAccount.getAccountNum();
		int length = Long.toString(Math.abs(accNum)).length();
		if(length != accountNumLen) {
			throw new Exception("The length of the coount Number must be 12");
		}
		BankAccount newAccount = bankDao.save(bankAccount);
		return newAccount.getId()+"";
	}
	
	public BankAccount getAccountBayAccountNum( long accountNum) {
		return bankDao.findByAccountNum(accountNum);
	}

	
	public void updateTheBankAccount(BankAccount bankAccount, String type) {
		long accountNum = bankAccount.getAccountNum();
		double amount = bankAccount.getBalance();
		BankAccount updaetedBank = getAccountBayAccountNum(accountNum);
		double balance = updaetedBank.getBalance();
		
		if(type.equalsIgnoreCase(DEBIT)) {
			updaetedBank.setBalance(balance - amount);
		}else if(type.equalsIgnoreCase(credit)){
			updaetedBank.setBalance(balance + amount);
		}
		
		bankDao.save(updaetedBank);
	}
	
}