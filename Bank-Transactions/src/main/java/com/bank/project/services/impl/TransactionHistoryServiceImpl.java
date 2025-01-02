package com.bank.project.services.impl;

import org.springframework.stereotype.Service;

import com.bank.project.models.TransactionHistory;
import com.bank.project.repositories.TransactionHistoryRepository;
import com.bank.project.services.TransactionHistoryService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TransactionHistoryServiceImpl implements TransactionHistoryService {
	
    private final TransactionHistoryRepository transactionHistoryRepository;

    @Autowired
    public TransactionHistoryServiceImpl(TransactionHistoryRepository transactionHistoryRepository) {
        this.transactionHistoryRepository = transactionHistoryRepository;
    }

    @Override
	public TransactionHistory createTransaction(TransactionHistory transactionHistory) {
        return transactionHistoryRepository.save(transactionHistory);
    }

    @Override
	public List<TransactionHistory> getTransactionsByAccountId(Integer accountId) {
        return transactionHistoryRepository.findAllByAccount_AccountId(accountId);
    }

    @Override
	public List<TransactionHistory> getTransactionsByCustomerId(Integer customerId) {
        return transactionHistoryRepository.findAllByCustomer_CustomerId(customerId);
    }
}
