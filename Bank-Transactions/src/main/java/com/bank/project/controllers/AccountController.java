
package com.bank.project.controllers;
import org.springframework.web.bind.annotation.*;

import com.bank.project.dto.CreateAccountRequestDTO;
import com.bank.project.dto.ResponseDTO;
import com.bank.project.models.Account;
import com.bank.project.models.Customer;
import com.bank.project.services.AccountService;
import com.bank.project.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

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

    @PostMapping(value ="/createAccount",consumes = MediaType.APPLICATION_JSON_VALUE ,  produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseDTO<Customer> createAccount(@RequestBody CreateAccountRequestDTO requestDto) {
    	return new ResponseDTO<>(HttpStatus.CREATED.value(), customerService.createCustomer(requestDto), java.time.ZonedDateTime.now().toString());
    }

    @GetMapping("/get-accounts")
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
