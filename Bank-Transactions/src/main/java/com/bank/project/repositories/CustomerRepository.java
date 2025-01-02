package com.bank.project.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.project.models.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // Find customers by name
    @Query("SELECT c FROM Customer c WHERE c.name = :name")
    List<Customer> findByName(@Param("name") String name);

    // Find customers by email
    @Query("SELECT c FROM Customer c WHERE c.email = :email")
    List<Customer> findByEmail(@Param("email") String email);

    // Find customers by phone number
    @Query("SELECT c FROM Customer c WHERE c.phoneNumber = :phoneNumber")
    List<Customer> findByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    // Find customer by ID
    @Query("SELECT c FROM Customer c WHERE c.customerId = :customerId")
    Optional<Customer> findByCustomerId(@Param("customerId") Integer customerId);
}
