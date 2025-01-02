
-- Inserting Customers
INSERT INTO customers (name, email, phone_number, address) 
VALUES ('John Doe', 'john.doe@example.com', '1234567890', '123 Main St, City, Country');

INSERT INTO customers (name, email, phone_number, address) 
VALUES ('Jane Smith', 'jane.smith@example.com', '0987654321', '456 Oak St, City, Country');



-- Inserting Branch Details
INSERT INTO branch_details (branch_code, location, ifsc_code) 
VALUES ('BR001', 'New York', 'NYC12345');
INSERT INTO branch_details (branch_code, location, ifsc_code) 
VALUES ('BR002', 'Los Angeles', 'LA12345');

-- Inserting Branch Details
INSERT INTO EMPLOYEE (EMPLOYEE_NAME, BRANCH_CODE) 
VALUES ('abot','BR001');

-- Inserting Accounts
INSERT INTO account (account_number, balance, customer_id, CREATED_BY, branch_code) 
VALUES ('ACC1234567890', 1000.00, 1, 1 ,'BR001');

INSERT INTO account (account_number, balance, customer_id,CREATED_BY, branch_code) 
VALUES ('ACC0987654321', 1500.00, 2,1, 'BR002');

-- Inserting Transaction History
INSERT INTO transaction_history (transaction_date, amount, transaction_type, description, account_id, customer_id, balance_after_transaction)
VALUES (CURRENT_TIMESTAMP, 500.00, 'CREDIT', 'Deposit via bank transfer', 2, 2, 1500.00);

INSERT INTO transaction_history (transaction_date, amount, transaction_type, description, account_id, customer_id, balance_after_transaction)
VALUES (CURRENT_TIMESTAMP, 100.00, 'DEBIT', 'Withdrawal at ATM', 1, 1, 900.00);

