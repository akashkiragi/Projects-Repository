package com.bank.project.controllers;

import org.springframework.web.bind.annotation.*;

import com.bank.project.models.TransactionHistory;
import com.bank.project.services.TransactionHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionHistoryController {
    private final TransactionHistoryService transactionHistoryService;

    @Autowired
    public TransactionHistoryController(TransactionHistoryService transactionHistoryService) {
        this.transactionHistoryService = transactionHistoryService;
    }

    @PostMapping
    public TransactionHistory createTransaction(@RequestBody TransactionHistory transactionHistory) {
        return transactionHistoryService.createTransaction(transactionHistory);
    }

    @GetMapping("/account/{accountId}")
    public List<TransactionHistory> getTransactionsByAccountId(@PathVariable Integer accountId) {
        return transactionHistoryService.getTransactionsByAccountId(accountId);
    }

    @GetMapping("/customer/{customerId}")
    public List<TransactionHistory> getTransactionsByCustomerId(@PathVariable Integer customerId) {
        return transactionHistoryService.getTransactionsByCustomerId(customerId);
    }
}
