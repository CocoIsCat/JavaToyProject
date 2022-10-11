package Group;

import Customer.Customer;
import Customer.Customers;

public class Group {

    enum CustomerRating {GENERAL, VIP, VVIP}

    private CustomerRating customerRating;  //고객 등급
    private Customers groupMember;  //그룹에 속한 고객

    Group() {}

    Group(CustomerRating customerRating, Customers groupMember) {
        this.customerRating = customerRating;
        this.groupMember = groupMember;
    }

    public CustomerRating getCustomerRating() {
        return customerRating;
    }

    public void setCustomerRating(CustomerRating customerRating) {
        this.customerRating = customerRating;
    }

    public Customers getGroupMember() {
        return groupMember;
    }

    public void setGroupMember(Customers groupMember) {
        this.groupMember = groupMember;
    }
}
