package Group;

import Customer.Customer;
import Customer.Customers;

import java.util.Collections;
import java.util.Comparator;


public class Group {

    public enum GroupRating {GENERAL, VIP, VVIP}
    private GroupRating groupRating;  //고객 등급
    private Customers groupMember = new Customers(new Customer[10]);  //그룹에 속한 고객
    private GroupParameter groupParameter;   //등급

    public Group() {}

    public Group(GroupRating groupRating) {
        this.groupRating = groupRating;
    }

    public GroupParameter getGroupParameter() {
        return groupParameter;
    }

    public void setGroupParameter(GroupParameter groupParameter) {
        this.groupParameter = groupParameter;
    }

    public GroupRating getCustomerRating() {
        return groupRating;
    }

    public void setCustomerRating(GroupRating groupRating) {
        this.groupRating = groupRating;
    }

    public Customers getGroupMember() {
        return groupMember;
    }

    public void setGroupMember(Customers groupMember) {
        this.groupMember = groupMember;
    }
    public void sortByName(boolean isAscending) {
        this.groupMember.sortByName(isAscending);
    }

    public void sortByTime(boolean isAscending) {
        this.groupMember.sortByTime(isAscending);
    }

    public void sortBySpend(boolean isAscending) {
        this.groupMember.sortBySpend(isAscending);
    }
}
