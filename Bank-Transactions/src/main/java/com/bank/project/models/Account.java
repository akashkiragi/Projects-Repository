package com.bank.project.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="account")
public class Account implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3759736554757310698L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    @Column(unique = true, nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private Double balance;
    
    @Column(nullable = false)
    private String createdBy;

    @ManyToOne(fetch = FetchType.EAGER) // Ensure EAGER loading
    @JoinColumn(name = "customer_id",referencedColumnName = "customerId")
    @JsonBackReference // Prevent infinite recursion during serialization
    private Customer customer;  
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_code", referencedColumnName = "branch_code", nullable = false)
    @JsonManagedReference
    private BranchDetails branchDetails;

   // @JsonManagedReference
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TransactionHistory> transactions;

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<TransactionHistory> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionHistory> transactions) {
		this.transactions = transactions;
	}

	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public BranchDetails getBranchDetails() {
		return branchDetails;
	}

	public void setBranchDetails(BranchDetails branchDetails) {
		this.branchDetails = branchDetails;
	}
	
	

    // Getters and Setters
}
