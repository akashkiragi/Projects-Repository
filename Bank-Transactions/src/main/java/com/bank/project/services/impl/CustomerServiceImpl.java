package com.bank.project.services.impl;

import org.springframework.stereotype.Service;

import com.bank.project.dto.CreateAccountRequestDTO;
import com.bank.project.models.Account;
import com.bank.project.models.BranchDetails;
import com.bank.project.models.Customer;
import com.bank.project.repositories.CustomerRepository;
import com.bank.project.services.CustomerService;
import com.bank.project.utils.BankAccountConstants;
import com.bank.project.utils.BankDataUtils;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRepository;
	
	@Autowired
	private BankDataUtils bankDataUtils;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Customer createCustomer(CreateAccountRequestDTO requestDTO) {		
		
		
		Customer custDetails =requestDTO.getCustomerDTO().getCustomer();		
		String branchCode = requestDTO.getBranch().getBranchCode();
		
		Account account = new Account();
		BranchDetails branchDetails = new BranchDetails(branchCode);
		account.setBalance(BankAccountConstants.ZERO);
		String accNum = bankDataUtils.createAccountNumber(branchCode);
		account.setAccountNumber(accNum);
		account.setBranchCode(branchCode);
		account.setCreatedBy(1);
		account.setCustomer(custDetails);
		custDetails.setAccount(account);
		return customerRepository.save(custDetails);
		
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Optional<Customer> getCustomerById(Integer id) {
		return customerRepository.findById(id);
	}

	public Customer updateCustomer(Integer id, Customer updatedCustomer) {
		return customerRepository.findById(id).map(customer -> {
			customer.setName(updatedCustomer.getName());
			customer.setEmail(updatedCustomer.getEmail());
			customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
			customer.setAddress(updatedCustomer.getAddress());
			return customerRepository.save(customer);
		}).orElseThrow(() -> new RuntimeException("Customer not found"));
	}

	public void deleteCustomer(Integer id) {
		customerRepository.deleteById(id);
	}

}
