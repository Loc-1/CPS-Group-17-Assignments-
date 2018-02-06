/**
 * Class is a simple bank account with balance and overdraft amount instance variables. The class is extended
 * by a customer class.
 */
public class BankAccount {
    private double balance;
    private double overdraftAmount = 100;
    private Customer customer;

    /**
     * Constructor with params.
     *
     * @param setCustomer the customer's customer instance.
     * @param setBalance  the desired balance to apply as a double.
     */
    public BankAccount(Customer setCustomer, double setBalance) {
        this.customer = setCustomer;
        this.balance = setBalance;
    }

    /**
     * A default account with a balance of 0.
     */
    public BankAccount() {
        this.balance = 0;
    }

    /**
     * @param amount the amount to deposit as a double.
     */
    public void deposit(double amount) {
        if (amount < 0) {
            System.out.println("You can not deposit a negative amount.");
        } else {
            this.balance = this.balance + amount;
        }

    }

    /**
     * Withdraw amount is confirmed against the user's balance plus overdraft.
     *
     * @param amount the amount to withdraw as a double.
     */
    public void withdraw(double amount) {
        if (amount > this.overdraftAmount + this.balance) {
            System.out.println("You can not withdraw more than $" + this.overdraftAmount + " over your balance of $"
                    + this.balance);
        } else {
            this.balance = this.balance - amount;
        }

    }

    public void setOverdraftAmount(double newAmount) {
        this.overdraftAmount = newAmount;
    }
    
    public void setCustomer(Customer newCustomer) {
    	this.customer = newCustomer;
    }

    public double getBalance() {
        return this.balance;
    }

    public Customer getCustomer() {
        return this.customer;
    }

}
