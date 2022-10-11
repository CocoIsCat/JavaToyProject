package Group;

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

    /*public Group sortByName
    * - 이름 순 정렬*/
    public Group sortByName() {

    }

    /*public Group sortByTime
    * - 소요 시간 순 정렬*/
    public Group sortByTime() {

    }

    /*public Gorup sortBySpend
    * - 소비 금액 순 정렬*/
    public Group sortBySpend() {

    }
}
