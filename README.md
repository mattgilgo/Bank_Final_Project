# Bank_Final_Project

## Needs
# Checking account service
# Savings account service
# Ability to get a loan

## Upon logging in…

	# If I am a customer:
		First, create account
		Then, deposit into account and withdraw money from account
		Or, if enough money in account, get a bank loan
	
	# If I am a bank manager:
		See who the customers are
		See what transactions the customers have made 

# IMPORTANT: Persistence - if bank service goes down, their information/money should not go away

## Stock Info

# Rich people ($5000 in their savings account) can by stonks:
	They will have the ability to transfer at least $1000 into a securities account
	They must at least maintain a savings account of $2500 while trading stonks
	In the securities account, they can:
		Buy and sell stock
		See current open positions
		See both realized and unrealized profit

# With stonks, bank manager must:
	Maintain a list of stocks that his customers are able to trade
	Update the current price of each stock

## Notes:
Charge fee every time an account is opened or closed
Charge fee every time a checking account transaction or any withdrawal has been made
Only pay interest on savings accounts with high balances
Charge interest on loans
F THE CUSTOMER WE BOUT THAT CASH!!! $$$$$$
Don’t have to have SQL database, can just use files if we are having issues
