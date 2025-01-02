package com.bank.project.services;

import java.util.List;

import com.bank.project.models.TransactionHistory;

public interface TransactionHistoryService {

	TransactionHistory createTransaction(TransactionHistory transactionHistory);

	List<TransactionHistory> getTransactionsByAccountId(Integer accountId);

	List<TransactionHistory> getTransactionsByCustomerId(Integer customerId);

}