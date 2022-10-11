package Management;

import Customer.Customer;

public class AddUser {
    public static void adduser(Customer[] customers, Customer[] newCustomers) {
        for (Customer CST : newCustomers) {
            try {
                customers[DataBase.index] = CST;
            } catch (ArrayIndexOutOfBoundsException e) {
                /*배열 크기 두 배로 늘리기*/
                customers[DataBase.index] = CST;
            }
        }
    }
}
