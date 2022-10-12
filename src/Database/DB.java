package Database;

import Customer.Customer;
import Customer.Customers;
import Group.Group;
import Group.Groups;

public class DB {
    public static Customers customers = new Customers(new Customer[10]);
    public static Groups groups = new Groups(new Group[]{new Group(Group.GroupRating.VVIP), new Group(Group.GroupRating.VIP), new Group(Group.GroupRating.GENERAL), new Group()});
}
