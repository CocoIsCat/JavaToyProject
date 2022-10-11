package Management;

import Customer.Customer;

public class AddUser {
    public static void adduser(Customer[] newCustomers) {
        for (Customer CST : newCustomers) {
            try {
                DataBase.customers[DataBase.index++] = CST;
            } catch (ArrayIndexOutOfBoundsException e) {
                /*배열 크기 두 배로 늘리기*/
                DataBase.customers[DataBase.index++] = CST;
            }
        }
    }
}
