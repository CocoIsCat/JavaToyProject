package Customer;

import java.util.Arrays;
import java.util.Comparator;

public class Customers {

    private Customer[] customers;

    public Customers() {}

    public Customers(Customer[] customers) {
        this.customers = customers;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public void sortByName(boolean isAscending) {
        if(isAscending) {   //오름차순
            Arrays.sort(customers, new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    return o1.getCustomerName().compareTo(o2.getCustomerName());
                }
            });
        }
        else {  //내림차순
            Arrays.sort(customers, new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    return o1.getCustomerName().compareTo(o2.getCustomerName()) * -1;
                }
            });
        }
    }

    public void sortByTime(boolean isAscending) {
        if(isAscending) {   //오름차순
            Arrays.sort(customers, new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    return o1.getUseTime() - o2.getUseTime();
                }
            });
        }
        else {  //내림차순
            Arrays.sort(customers, new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    return o2.getUseTime() - o1.getUseTime();
                }
            });
        }
    }

    public void sortBySpend(boolean isAscending) {
        if(isAscending) {   //오름차순
            Arrays.sort(customers, new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    return o1.getPaymentAmount() - o2.getPaymentAmount();
                }
            });
        }
        else {  //내림차순
            Arrays.sort(customers, new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    return o2.getPaymentAmount() - o1.getPaymentAmount();
                }
            });
        }
    }
}
