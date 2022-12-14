package Group;

import Customer.Customer;
import Customer.Customers;

import java.util.Collections;
import java.util.Comparator;


public class Group {

    public enum GroupRating {GENERAL, VIP, VVIP, NORMAL}
    private GroupRating groupRating;  //고객 등급
    private Customers groupMember;  //그룹에 속한 고객
    private GroupParameter groupParameter;   //등급

    public Group() {}

    public Group(GroupRating groupRating) {
        this.groupRating = groupRating;
        this.groupMember = new Customers(new Customer[10]);
        this.groupParameter = new GroupParameter(0,0);
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
}
