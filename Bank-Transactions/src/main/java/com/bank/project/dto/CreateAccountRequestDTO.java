package com.bank.project.dto;

import com.bank.project.models.Account;
import com.bank.project.models.BranchDetails;
import com.bank.project.models.Customer;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateAccountRequestDTO {
	
	
	private Customer customer;
	private BranchDetails branchDetails;
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public BranchDetails getBranchDetails() {
		return branchDetails;
	}
	public void setBranchDetails(BranchDetails branchDetails) {
		this.branchDetails = branchDetails;
	}
	
	
	
	/*
	 * 
	 * @NotNull private CustomerDTO customer;
	 * 
	 * @NotNull private AccountDTO account;
	 * 
	 * @NotNull private BranchDTO branch;
	 * 
	 * // Getters and setters
	 * 
	 * public CustomerDTO getCustomer() { return customer; }
	 * 
	 * public void setCustomer(CustomerDTO customer) { this.customer = customer; }
	 * 
	 * public AccountDTO getAccount() { return account; }
	 * 
	 * public void setAccount(AccountDTO account) { this.account = account; }
	 * 
	 * public BranchDTO getBranch() { return branch; }
	 * 
	 * public void setBranch(BranchDTO branch) { this.branch = branch; }
	 * 
	 * // Nested DTOs for Customer, Account, and Branch public static class
	 * CustomerDTO {
	 * 
	 * @NotBlank private String name;
	 * 
	 * @NotBlank private String email;
	 * 
	 * @NotBlank private String phoneNumber;
	 * 
	 * @NotBlank private String address;
	 * 
	 * // Getters and setters
	 * 
	 * public String getName() { return name; }
	 * 
	 * public void setName(String name) { this.name = name; }
	 * 
	 * public String getEmail() { return email; }
	 * 
	 * public void setEmail(String email) { this.email = email; }
	 * 
	 * public String getPhoneNumber() { return phoneNumber; }
	 * 
	 * public void setPhoneNumber(String phoneNumber) { this.phoneNumber =
	 * phoneNumber; }
	 * 
	 * public String getAddress() { return address; }
	 * 
	 * public void setAddress(String address) { this.address = address; } }
	 * 
	 * public static class AccountDTO {
	 * 
	 * @NotBlank private String accountNumber;
	 * 
	 * @NotNull private Double balance;
	 * 
	 * // Getters and setters
	 * 
	 * public String getAccountNumber() { return accountNumber; }
	 * 
	 * public void setAccountNumber(String accountNumber) { this.accountNumber =
	 * accountNumber; }
	 * 
	 * public Double getBalance() { return balance; }
	 * 
	 * public void setBalance(Double balance) { this.balance = balance; } }
	 * 
	 * public static class BranchDTO {
	 * 
	 * @NotBlank private String branchName;
	 * 
	 * @NotBlank private String branchCode;
	 * 
	 * private String branchAddress;
	 * 
	 * // Getters and setters
	 * 
	 * public String getBranchName() { return branchName; }
	 * 
	 * public void setBranchName(String branchName) { this.branchName = branchName;
	 * }
	 * 
	 * public String getBranchCode() { return branchCode; }
	 * 
	 * public void setBranchCode(String branchCode) { this.branchCode = branchCode;
	 * }
	 * 
	 * public String getBranchAddress() { return branchAddress; }
	 * 
	 * public void setBranchAddress(String branchAddress) { this.branchAddress =
	 * branchAddress; } }
	 */}
