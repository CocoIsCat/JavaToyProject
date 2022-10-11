package Management;

import Customer.Customer;
import Database.DB;

public class AddUser {
    public static void adduser(Customer[] newCustomers) {
        for (Customer CST : newCustomers) {
            try {
                DB.customers[DB.index++] = CST;
            } catch (ArrayIndexOutOfBoundsException e) {
                /*배열 크기 두 배로 늘리기*/
                DB.customers[DB.index++] = CST;
            }
        }
    }
}
