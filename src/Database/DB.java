package Database;

import Customer.Customer;
import Customer.Customers;
import Group.GroupParameter;

public class DB {
    public static int index = 0;
    public static Customers customers = new Customers(new Customer[10]);

    public static GroupParameter[] groupParameters = new GroupParameter[3];
}
