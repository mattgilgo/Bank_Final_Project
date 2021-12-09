# Bank_Final_Project

## Requirements
#### There should be two types of users of the bank:
1. Customer:
    a. Must be able to create/delete checking, savings, trading, and loan accounts (what is the fee to be charged for account creation/deletion?   
    b. Checking accounts can be deposited into and withdrawn from (what are transactions that cost fees?)
- 			Savings accounts can be deposited into and withdrawn from and high balance accounts accumulate interest (what should interest rates be?)
- 			Trading accounts can be used to buy and sell stock, see current stock portfolio, and see unrealized gains and losses
- 			Loan accounts must be charged interest 
- 		Must be able to manipulate each type of account
- 	Manager:
- 		Must be able see who the customers are
- 		Must be able to see what transactions the customers have made
- 		Must be able to maitain and manipulate the stock market

- Persistence - if bank service goes down, their information/money should not go away (use database in backend to capture all necessary information)

## Summary of Questions:
1. What is the fee to be charged for account creation/deletion?
2. What are transactions that cost fees?
3. What should interest rates be and what should the balance be to accumulate interest?
4. Do we need a separate table for interest rates, or can it be a static interest determined by a randomized method upon giving the loan?
5. Can the manager see how much money his customers have when he pulls the customer log?

## Notes:
Only pay interest on savings accounts with high balances
If we can't get the SQL database working we can use files instead
