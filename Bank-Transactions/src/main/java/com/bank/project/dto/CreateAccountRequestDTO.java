package com.bank.project.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.bank.project.models.Customer;

public class CreateAccountRequestDTO {

	@NotNull
	private CustomerDTO customer;

	@NotNull
	private AccountDTO account;

	@NotNull
	private BranchDTO branch;

	// Getters and setters

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public AccountDTO getAccount() {
		return account;
	}

	public void setAccount(AccountDTO account) {
		this.account = account;
	}

	public BranchDTO getBranch() {
		return branch;
	}

	public void setBranch(BranchDTO branch) {
		this.branch = branch;
	}

	// Nested DTOs for Customer, Account, and Branch
	public static class CustomerDTO {

		@NotBlank
		private String name;

		@NotBlank
		private String email;

		@NotBlank
		private String phoneNumber;

		@NotBlank
		private String address;

		// Getters and setters

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}	
		
	}

	public static class AccountDTO {

		
		@NotNull
		private Double balance;
		
		public Double getBalance() {
			return balance;
		}

		public void setBalance(Double balance) {
			this.balance = balance;
		}
	}

	public static class BranchDTO {		

		@NotBlank
		private String branchCode;

		
		public String getBranchCode() {
			return branchCode;
		}

		public void setBranchCode(String branchCode) {
			this.branchCode = branchCode;
		}
		
	}
}
