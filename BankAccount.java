
/**
 * Basic bank account program which allows user to withdraw and deposit.
 * The balance of the bank account can never be overdrafted more than the allowed amount.
 */ 
public class BankAccount {
	double balance = 0.0; // Initialize the bank account balance.
	double overdraftAmount = 100.0; // Initialize the banka ccount overdrafft amount.
	private Customer customer = new Customer("Bob",100);
	
	/**
	 * Constructs a BankAccount no arguments
	 */
	public BankAccount() {
		
	}
	
	/**
	 * Constructs a BankAccount given a customer and a balance
	 */
	public BankAccount(Customer aCustomer, double aBalance) {
		customer = aCustomer;
		balance = aBalance;
	}
	
	/**
	 * Constructs the initial customer
	 */
	public BankAccount(Customer c1) {
		customer = c1;
	}
	
	/**
	 * Constructs the initial balance
	 */
	public BankAccount(double initialBalance) {
		balance = initialBalance;
	}
	
	/**
	 * Sets the customer 
	 */
	public void setCustomer(Customer person) {
		this.customer = person;
	}
	
	/**
	 * @param amount The amount of money the user wishes to deposit.
	 */
	public void deposit(double amount){
		if (amount < 0.0){
			System.out.println("You can not deposit a negative amount, please withdraw instead.");
		} else {
		balance += amount;
		}
	}
	
	/**
	 * @param amount The amount of money the user wishes to withdraw.
	 */
	public void withdraw(double amount){
		if (amount < 0.0) {
			System.out.println("You can not withdraw a negative amount, please deposit instead.");
		} else if (amount >= (overdraftAmount + balance)) {
			System.out.println("You can not withdraw this amount as you will exceed the overdraft amount.");
		} else {
		balance -= amount;
		}
	}
	
	/**
	 * @return The current balance in the account as a double.
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Gets the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param newOverdraftAmount defines a new overdraft amount for the bank account.
	 */
	public void setOverdraftAmount(double newOverdraftAmount) {
		overdraftAmount = newOverdraftAmount;
	}

}