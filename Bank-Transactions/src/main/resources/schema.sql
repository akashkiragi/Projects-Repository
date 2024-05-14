CREATE TABLE IF NOT EXISTS bank_account (
    id VARCHAR(255) PRIMARY KEY,
    account_num BIGINT,
    balance FLOAT NOT NULL,
    name VARCHAR(255)
);
