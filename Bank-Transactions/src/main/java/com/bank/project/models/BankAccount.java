package com.bank.project.models;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="bank_account", uniqueConstraints = @UniqueConstraint(columnNames ={"accountNum"}))
public class BankAccount {

		@Id
		//@GeneratedValue(strategy = GenerationType.)
		private String id =  UUID.randomUUID().toString();
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
 