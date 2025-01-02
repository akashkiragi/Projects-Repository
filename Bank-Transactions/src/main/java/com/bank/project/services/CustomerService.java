package com.bank.project.services;

import java.util.List;
import java.util.Optional;

import com.bank.project.models.Customer;

public interface CustomerService {

	Customer createCustomer(Customer customer);

	void deleteCustomer(Integer id);

	Customer updateCustomer(Integer id, Customer updatedCustomer);

	List<Customer> getAllCustomers();

	Optional<Customer> getCustomerById(Integer id);

}
