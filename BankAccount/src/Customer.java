/**
 * Class containing instance variables for a Customer's name and id.
 */
public class Customer {
	private String name;
	private int customerID;

    /**
     * @param setName the customer's name as a string.
     * @param setCustomerID the customers ID as an int.
     */
	public Customer(String setName, int setCustomerID) {
		this.name = setName;
		this.customerID = setCustomerID;
	}

    /**
     * @return customer's name and ID formatted as "Customer: <name>, <customerID>"
     */
    public String toString() {
        return "Customer: " + this.name + ", " + this.customerID;
    }

	public String getName() { return this.name; }

	public int getCustomerID() { return this.customerID; }

	public void setName(String n) { this.name = n; }

	public void setCustomerID(int i) { this.customerID = i; }

}
