-- Create Accounts Table
CREATE TABLE Accounts (
    account_id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    account_number VARCHAR(20) NOT NULL UNIQUE,
    balance DECIMAL(15, 2) NOT NULL,
    customer_id INT NOT NULL,
    PRIMARY KEY (account_id),
    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);

-- Create Transaction History Table
CREATE TABLE TransactionHistory (
    transaction_id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    account_id INT NOT NULL,
    customer_id INT NOT NULL,
    transaction_type VARCHAR(10) NOT NULL, -- Use values like 'Credit' or 'Debit'
    amount DECIMAL(15, 2) NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    balance_after_transaction DECIMAL(15, 2) NOT NULL,
    PRIMARY KEY (transaction_id),
    CONSTRAINT fk_account FOREIGN KEY (account_id) REFERENCES Accounts(account_id),
    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);

-- Create Customers Table
CREATE TABLE Customers (
    customer_id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone_number VARCHAR(15),
    address VARCHAR(255),
    PRIMARY KEY (customer_id)
);

-- Create Branch Details Table
CREATE TABLE BranchDetails (
    branch_id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    branch_code VARCHAR(20) NOT NULL UNIQUE,
    location VARCHAR(100) NOT NULL,
    ifsc_code VARCHAR(20) NOT NULL UNIQUE,
    PRIMARY KEY (branch_id)
);
