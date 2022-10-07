package Customer;

public class Customers {

    private Customer[] customers;

    Customers() {}

    Customers(Customer[] customers) {
        this.customers = customers;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

}
