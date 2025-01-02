package com.bank.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.bank.project.models.TransactionHistory;
import org.springframework.data.repository.query.Param;


public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Integer> {

    // Find transactions by account ID
    @Query("SELECT t FROM TransactionHistory t WHERE t.account.accountId = :accountId")
    List<TransactionHistory> findAllByAccount_AccountId(@Param("accountId") Integer accountId);

    // Find transactions by customer ID
    @Query("SELECT t FROM TransactionHistory t WHERE t.customer.customerId = :customerId")
    List<TransactionHistory> findAllByCustomer_CustomerId(@Param("customerId") Integer customerId);

    // Find transactions for a specific type (debit/credit)
    @Query("SELECT t FROM TransactionHistory t WHERE t.transactionType = :transactionType")
    List<TransactionHistory> findTransactionsByType(@Param("transactionType") String transactionType);
}
