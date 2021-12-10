# Bank_Final_Project

## Requirements
### There should be two types of users of the bank:
#### Customer:
##### - Must be able to create/delete checking, savings, trading, and loan accounts (what is the fee to be charged for account creation/deletion?   
1. Checking accounts can be deposited into and withdrawn from (what are transactions that cost fees?)
2. Savings accounts can be deposited into and withdrawn from and high balance accounts accumulate interest (what should interest rates be?)
3. Trading accounts can be used to buy and sell stock, see current stock portfolio, and see unrealized gains and losses
4. Loan accounts must be charged interest 
##### - Must be able to manipulate each type of account
#### Manager:
##### - Must be able see who the customers are
##### - Must be able to see what transactions the customers have made
##### - Must be able to maitain and manipulate the stock market

### Persistence 
#### - if bank service goes down, their information/money should not go away (use database in backend to capture all necessary information)

## Summary of Questions:
1. What is the fee to be charged for account creation/deletion?
2. What are transactions that cost fees?
3. What should interest rates be and what should the balance be to accumulate interest?
4. Do we need a separate table for interest rates, or can it be a static interest determined by a randomized method upon giving the loan?
5. Can the manager see how much money his customers have when he pulls the customer log?
6. How are we handling different currencies? - Interface for each currency?
   1. Should we have different account types for each currency? 
7. Should we use a Factory for each account type? 
## Notes:
Only pay interest on savings accounts with high balances
If we can't get the SQL database working we can use files instead

## Demo Notes (from Christine Meeting)

- Pretend we are new customer
- Pretend we are an existing customer - make a new transaction
- Show securities - can you trade?
- Do we have persistence built in?
- Rate is just a number or an object associated with a class
- Manager should be able to see user balances
- We might need slides
   - Team intro
   - Who did what?
   - Setup demo:
      - These are the important features
