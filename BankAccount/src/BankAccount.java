public class BankAccount {

	private double balance;
	private double overdraftAmount = 100;
	private Customer c;

	public BankAccount(Customer stC, double stBalance) {
		this.c = stC;
		this.balance = stBalance;
	}

	public void deposit(double amount) {

		if (amount < 0) {
			System.out.println("You can not deposit a negative amount.");
		} else {
			this.balance = this.balance + amount;
		}

	}

	public void withdraw(double amount) {

		if (amount > this.overdraftAmount + this.balance) {
			System.out.println("You can not withdraw more than $" + this.overdraftAmount + " over your balance.");
		} else {
			this.balance = this.balance - amount;
		}

	}

	public double getBalance() {
		return this.balance;
	}

	public Customer getCustomer() {
		return this.c;
	}

	public void setOverdraftAmount(double newAmount) {
		this.overdraftAmount = newAmount;
	}
}
