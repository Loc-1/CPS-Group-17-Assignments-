/**
 * Class containing instance variables for a Customer's name and id.
 */
public class Customer extends BankAccount {
    private String name;
    private int customerID;

    /**
     * Creates a new customer with params.
     *
     * @param setName       the desired name as a String.
     * @param setCustomerID the desired customer ID.
     */
    public Customer(String setName, int setCustomerID) {
        this.name = setName;
        this.customerID = setCustomerID;
    }

    /**
     * Copies a customer object when a customer object is passed.
     *
     * @param setCustomer the customer object to copy.
     */
    public Customer(Customer setCustomer) {
        this.name = setCustomer.name;
        this.customerID = setCustomer.customerID;
    }

    /**
     * Creates a default customer.
     */
    public Customer() {
        this.name = "";
        this.customerID = 0;
    }

    /**
     * @return customer's name and ID formatted as "Customer: <name>, <customerID>"
     */
    public String toString() {
        return "Customer: " + this.name + ", " + this.customerID;
    }
    
    public void setName(String newName) {
    	this.name = newName;
    }
    
    public void setID(int newCustomerID) {
    	this.customerID = newCustomerID;
    }

    public String getName() {
        return this.name;
    }

    public int getID() {
        return this.customerID;
    }

}
