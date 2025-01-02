package com.bank.project.utils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bank.project.models.Customer;

@Component
public class BankDataUtils {

	 //@Value("${customer.required.fields}")
	    private String requiredFields;

	    public void validateCustomer(Customer customer) throws ValidationException {
	        // Split the comma-separated fields and validate each one
	        List<String> requiredFieldList = Arrays.asList(requiredFields.split(","));

	        for (String field : requiredFieldList) {
	            try {
	                // Use reflection to get the field value from the Customer object
	                Field customerField = Customer.class.getDeclaredField(field);
	                customerField.setAccessible(true);
	                Object value = customerField.get(customer);

	                if (value == null || (value instanceof String && ((String) value).isEmpty())) {
	                    throw new ValidationException("Field " + field + " cannot be null or empty");
	                }
	            } catch (NoSuchFieldException | IllegalAccessException e) {
	                // Handle exception if the field does not exist
	                throw new ValidationException("Invalid field: " + field);
	            }
	        }
	    }
}
