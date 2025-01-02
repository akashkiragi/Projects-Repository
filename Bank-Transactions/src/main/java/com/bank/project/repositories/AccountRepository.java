package com.bank.project.repositories;

import com.bank.project.models.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    // Find accounts by customer ID
    @Query("SELECT a FROM Account a WHERE a.customer.customerId = :customerId")
    List<Account> findByCustomerId(@Param("customerId") Integer customerId);

    // Find account by account number
    @Query("SELECT a FROM Account a WHERE a.accountNumber = :accountNumber")
    Account findByAccountNumber(@Param("accountNumber") String accountNumber);

    // Find accounts by balance greater than a specific amount
    @Query("SELECT a FROM Account a WHERE a.balance > :balance")
    List<Account> findAccountsByBalanceGreaterThan(@Param("balance") Double balance);
}
