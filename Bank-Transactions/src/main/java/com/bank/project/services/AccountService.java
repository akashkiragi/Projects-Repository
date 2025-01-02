package com.bank.project.services;

import java.util.List;
import java.util.Optional;

import com.bank.project.models.Account;

public interface AccountService {

	Account createAccount(Account account);

	List<Account> getAllAccounts();

	Optional<Account> getAccountById(Integer id);

	Account updateAccountBalance(Integer id, Double newBalance);

	void deleteAccount(Integer id);

}