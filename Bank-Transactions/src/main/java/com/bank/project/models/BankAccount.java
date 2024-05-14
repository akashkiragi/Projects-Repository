package com.bank.project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="bank_account", uniqueConstraints = @UniqueConstraint(columnNames ={"account_num"}))
public class BankAccount {

		@Id
		@GeneratedValue(strategy = GenerationType.UUID)
		private String id;
		private String name;
		private Long accountNum;
		private double balance;
		
		public BankAccount() { }

		public BankAccount(String name, Long accountNum, double balance) {
			this.name = name;
			this.accountNum = accountNum;
			this.balance = balance;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Long getAccountNum() {
			return accountNum;
		}

		public void setAccountNum(Long accountNum) {
			this.accountNum = accountNum;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}
		
		
		
}
 