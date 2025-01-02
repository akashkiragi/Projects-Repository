package com.bank.project.services.impl;

import org.springframework.stereotype.Service;

import com.bank.project.exception.AccountHandleException;
import com.bank.project.models.Account;
import com.bank.project.repositories.AccountRepository;
import com.bank.project.services.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
	public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
	public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
	public Optional<Account> getAccountById(Integer id) {
        return accountRepository.findById(id);
    }

    @Override
	public Account updateAccountBalance(Integer id, Double newBalance) {
        return accountRepository.findById(id).map(account -> {
            account.setBalance(newBalance);
            return accountRepository.save(account);
        }).orElseThrow(() -> new AccountHandleException("Failed to create accont as The length of the account Number should be 12",
				HttpStatus.NOT_ACCEPTABLE));
    }

    @Override
	public void deleteAccount(Integer id) {
        accountRepository.deleteById(id);
    }
}

