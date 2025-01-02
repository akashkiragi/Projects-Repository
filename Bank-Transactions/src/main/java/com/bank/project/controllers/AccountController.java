
package com.bank.project.controllers;
import org.springframework.web.bind.annotation.*;

import com.bank.project.dto.ResponseDTO;
import com.bank.project.models.Account;
import com.bank.project.models.Customer;
import com.bank.project.services.AccountService;
import com.bank.project.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
    private final AccountService accountService;
    
    private final CustomerService customerService;

    @Autowired
    public AccountController(AccountService accountService, CustomerService customerService) {
        this.accountService = accountService;
        this.customerService = customerService;
    }

    @PostMapping("/create")
    public ResponseDTO<Customer> createAccount(@RequestBody Customer Customer) {
    	return new ResponseDTO<>(HttpStatus.CREATED.value(), customerService.createCustomer(Customer), java.time.ZonedDateTime.now().toString());
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Optional<Account> getAccountById(@PathVariable Integer id) {
        return accountService.getAccountById(id);
    }

    @PutMapping("/{id}")
    public Account updateAccountBalance(@PathVariable Integer id, @RequestParam Double balance) {
        return accountService.updateAccountBalance(id, balance);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Integer id) {
        accountService.deleteAccount(id);
    }
}
