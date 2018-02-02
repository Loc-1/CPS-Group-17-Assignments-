public class Customer {

	private String name;
	private int customerID;

	public Customer(String stName, int stCustID) {
		this.name = stName;
		this.customerID = stCustID;
	}

	public String getName() {
		return this.name;
	}

	public int getCustomerID() {
		return this.customerID;
	}

	public void setName(String n) {
		this.name = n;
	}

	public void setCustomerID(int i) {
		this.customerID = i;
	}

	public String toString() {

		String asString = "Customer: " + this.name + ", " + this.customerID;
		return asString;
	}

}
