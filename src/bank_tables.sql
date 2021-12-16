CREATE TABLE stock_accounts(stock_instance_owned_id INTEGER PRIMARY KEY AUTOINCREMENT, account_id INTEGER NOT NULL, stock_id INTEGER NOT NULL, cash_balance REAL NOT NULL, stock_buy_price REAL NOT NULL, num_shares REAL NOT NULL, FOREIGN KEY (account_id) REFERENCES accounts(account_id), FOREIGN KEY (stock_id) REFERENCES stocks(stock_id));

CREATE TABLE stocks( stock_id INTEGER PRIMARY KEY AUTOINCREMENT, stock_ticker TEXT NOT NULL, stock_price REAL NOT NULL);

CREATE TABLE transactions( transaction_id INTEGER PRIMARY KEY AUTOINCREMENT, transaction_type TEXT NOT NULL, transaction_amount REAL NOT NULL, transaction_time DATETIME DEFAULT CURRENT_TIMESTAMP, account_id INTEGER NOT NULL, FOREIGN KEY (account_id) REFERENCES accounts(account_id));

CREATE TABLE accounts( account_id INTEGER PRIMARY KEY AUTOINCREMENT, user_id INTEGER NOT NULL, account_type TEXT NOT NULL, balance REAL NOT NULL, FOREIGN KEY (user_id) REFERENCES users(user_id));

CREATE TABLE users( user_id INTEGER PRIMARY KEY AUTOINCREMENT, user_type TEXT NOT NULL, username TEXT NOT NULL, password TEXT NOT NULL);

ALTER TABLE stock_accounts CHANGE stockInstanceOwnedID stock_instance_owned_id INTEGER, CHANGE cash_balance cash_balance REAL, CHANGE stock_buy_price stock_buy_price REAL, CHANGE num_shares num_shares REAL, ALGORITHM = COPY;


ALTER TABLE stock_accounts CHANGE accountID account_id int, CHANGE stockID stock_id int, ALGORITHM = INPLACE;


INSERT INTO users (user_type, username, password) VALUES ("C", "mattg", "almostdone");

INSERT INTO accounts (user_id, account_type, balance) VALUES (1, "CK", 1000.00);

INSERT INTO transactions (transaction_type, transaction_amount, account_id) VALUES ("W", 1000.00, 1);

INSERT INTO stocks (stock_ticker, stock_price) VALUES ("TSLA", 1100.00);

INSERT INTO stock_accounts (account_id, stock_id, cash_balance, stock_buy_price, num_shares) VALUES (1, 1, 5000.00, 1050.00, 2);