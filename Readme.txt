# CS611-Bank ATM

Team 29 Members:
-------------------------------------------------------------------------------------------------
Shilpen Patel
shilpenp@bu.edu
U52493692

Matthew Gilgo
msgilgo@bu.edu
U43413276

Justin DiEmmanuele
jd9@bu.edu
U64306920

George Padavick
georgep4@bu.edu
U47019144

Files
-------------------------------------------------------------------------------------------------
Account.java - Parent class of all possible account types in the Bank ATM
ATM.java - class called on by Bank which contains the appropriate logic to allow the Bank to have functionality for both the customer and manager
Bank.java - Highest level object that creates a Bank type object that creates an ATM object and had a Database object to implement functionality fo the Bank
Checking.java - Child class of account, implements a checking account type with appropriate methods
Currency.java - class used to create a currency object that is used to capture different currency types
Customer.java - Concrete child class of User, implements a Bank Customer type of user with appropriate methods
Database.java - class used to connect to a SQLlite database and query from to interface with the Bank object
Deposit.java - Child class of transaction, implements deposit transaction type methods
Factory.java - class implements the factory design patter by creating the appropriate object type for each account and user types
Loan.java - Child class of account, implements a loan account type with appropriate methods
LoanTransaction.java - Child class of transaction, implements transaction type methods for a loan account transaction
Main.java - class creates a new GameSession instance and launches program to select which game to play
Manager.java - Concrete child class of User, implements a Bank Manager type of user with appropriate methods
OwnedStock.java - class used to capture all the stock owned by a customer of the bank
Report.java - object used to hold all the necessary information fro a manager to see user information
ReportTuple.java - base object to represent a row of the report a manager user type will need to see
Savings.java - Child class of account, implements a savings account type with appropriate methods
Stock.java - class used to create a stock object to be used in the bank
StockMarket.java - class that implements all of the necessary methods to create a stock market
StockTransaction.java - Child class of transaction, implements transaction type methods for a trading account transaction
Trading.java - Child class of account, implements a trading account type with appropriate methods
Transaction.java - Parent class of all transaction types a customer can use
User.java - Abstract class of a generic user of the Bank
Withdrawal.java - Child class of transaction, implements withdraw transaction type methods
AccountCreationUI.java - User Interface Class for allowing user to create a new account
CustomerUI.java - User Interface Class for allowing customer user to navigate around the ATM and interface with the bank
ManagerUI.java - User Interface Class for allowing manager user to navigate around the ATM and interface with the bank
StockUI.java - User Interface Class for allowing customer user to navigate around the trading account to buy and sell stocks
TableUICreator.java - Generic User Interface class to create a display table UI object (used to generate various tables for both customers and managers)

Notes:
-------------------------------------------------------------------------------------------------
1. Full SQLlite Database Implemented
2. Bonus:
    i. Used the Factory design pattern to create the appropriate types of Users and Accounts in the Bank

How to run:
-------------------------------------------------------------------------------------------------
1. Navigate to the directory after downloading the project
2. Run the following instructions on command line:
	javac *.java
	java Main.java
