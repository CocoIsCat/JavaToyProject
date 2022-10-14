package Menus;

import Customer.Customer;
import Database.DB;
import java.util.Scanner;

public class CustomerMenu extends Menu{
    public static void printCustomerMenus() {
        while(true) {
            int menu = 0;
            System.out.printf("[ %s ]\n", "Manage Customer");
            System.out.println("========================================================================");
            System.out.printf("|%-70s|\n", " 1. Add Customer Data");
            System.out.printf("|%-70s|\n", " 2. View Customer Data");
            System.out.printf("|%-70s|\n", " 3. Update Customer Data");
            System.out.printf("|%-70s|\n", " 4. Delete Customer Data");
            System.out.printf("|%-70s|\n", " 5. Back");
            System.out.println("========================================================================");
            System.out.printf("Choose One : ");
            menu = new Scanner(System.in).nextInt();
            if(menu == 5) {
                System.out.println("\n");
                break;
            }
            else if (menu > 5 || menu < 1) {
                System.out.println("\nfuck\n");
            }
            else {
                System.out.println("\n");
                chooseCustomerMenu(menu);
            }
        }
    }

    private static void chooseCustomerMenu(int menu) {
        switch (menu) {
            case 1:
                addCustomerData();
                break;
            case 2:
                viewCustomerData();
                break;
            case 3:
                printupdateCustomerData();
                break;
            case 4:
                deleteCustomerData();
                break;
        }
    }

    private static void deleteCustomerData() {
        int num;
        System.out.printf("[ %s ]\n", "Delete Customer Data");
        System.out.println("============================================================================================================");
        System.out.printf("| %12s | %20s | %20s | %20s | %20s |\n", "Customer Num", "Customer Name", "Customer ID", "Use Time", "Payment Of Amount");
        System.out.println("============================================================================================================");
        if (DB.customers.elementNum() == 0) {
            System.out.printf("| %-104s |\n", "!!!No Customer Data!!!");
            System.out.println("============================================================================================================");
            System.out.printf("Enter Any Key To Exit : ");
            sc.next();
            System.out.println("\n");
        } else {
            for (int i = 0; i < DB.customers.elementNum(); i++) {
                System.out.printf("| %12s | %20s | %20s | %20s | %20s |\n", DB.customers.getCustomers()[i].getCustomerNum(), DB.customers.getCustomers()[i].getCustomerName(), DB.customers.getCustomers()[i].getCustomerID(), DB.customers.getCustomers()[i].getUseTime(), DB.customers.getCustomers()[i].getPaymentAmount());
            }
            System.out.println("============================================================================================================");
            while(true) {
                System.out.printf("Choose Customer Num : UID-");
                num = sc.nextInt();
                if (num < DB.customers.elementNum() & num >= 0) {
                    System.out.println("\n");
                    DB.customers.del(num);
                    break;
                }
                else {
                    System.out.println("\n fuck \n");
                }
            }
        }
    }

    private static void printupdateCustomerData() {
        int num = 0;
        System.out.printf("[ %s ]\n","Update Customer Data");
        System.out.printf("%108s\n", "| Current Data |");
        System.out.println("============================================================================================================");
        System.out.printf("| %12s | %20s | %20s | %20s | %20s |\n", "Customer Num", "Customer Name", "Customer ID", "Use Time", "Payment Of Amount");
        System.out.println("============================================================================================================");
        if(DB.customers.elementNum() == 0) {
            System.out.printf("| %-104s |\n","!!!No Customer Data!!!");
            System.out.println("============================================================================================================");
            System.out.printf("Enter Any Key To Exit : ");
            sc.next();
            System.out.println("\n");
        }
        else {
            for (int i = 0; i < DB.customers.elementNum(); i++) {
                System.out.printf("| %12s | %20s | %20s | %20s | %20s |\n", DB.customers.getCustomers()[i].getCustomerNum(), DB.customers.getCustomers()[i].getCustomerName(), DB.customers.getCustomers()[i].getCustomerID(), DB.customers.getCustomers()[i].getUseTime(), DB.customers.getCustomers()[i].getPaymentAmount());
            }
            System.out.println("============================================================================================================");
            while(true) {
                System.out.printf("Choose Customer Num : UID-");
                num = sc.nextInt();
                if (num < DB.customers.elementNum() & num >= 0) {
                    System.out.println("\n");
                    selectCustomerData(num);
                    break;
                }
                else {
                    System.out.println("\n fuck \n");
                }
            }
        }
    }

    private static void selectCustomerData(int num) {
        while(true) {
            int menu = 0;
            System.out.printf("[ %s ]\n", "Update Customer Data UID-" + num);
            System.out.println("=================================================================================");
            System.out.printf("| %-77s |\n", "Select Information To Update  (Exit : Enter 0)");
            System.out.println("=================================================================================");
            System.out.printf("| %s  %17s  %15s  %23s |\n", "1. Customer Name", "2. Customer ID", "3. Use Time", "4. Payment Of Amount");
            System.out.println("=================================================================================");
            System.out.printf("Choose One : ");
            menu = sc.nextInt();
            if (menu == 0) {
                System.out.println("\n");
                break;
            } else if (menu > 0 & menu < 5) {
                System.out.println("\n");
                updateCustomerData(num, menu);
                break;
            } else {
                System.out.println("\n fuck \n");
            }

        }
    }

    private static void updateCustomerData(int num, int menu) {
        Character answer;
        Customer CT = new Customer();
        switch (menu) {
            case 1:
                String name;
                do {
                    System.out.println("Before : " + DB.customers.getCustomers()[num].getCustomerName());
                    System.out.printf("Enter Name (Only English Characters With Spaces [length: 3 ~ 20]) : ");
                    name = sc.next();
                } while(!CT.setCustomerName(name));

                while(true) {
                    System.out.printf("Want to Update? (Y/N) : ");
                    answer = sc.next().toUpperCase().charAt(0);
                    if (answer == 'Y') {
                        DB.customers.getCustomers()[num].setCustomerName(name);
                        System.out.println("\n");
                        break;
                    }
                    else if (answer == 'N') {
                        System.out.println("\n");
                        break;
                    }
                    else {
                        System.out.println("\nfuck\n");
                    }
                }
                break;
            case 2:
                String id;
                do {
                    System.out.println("Before : " + DB.customers.getCustomers()[num].getCustomerID());
                    System.out.printf("Enter ID (English Letters And Numbers Only [length: 5 ~ 12]) : ");
                    id = sc.next();
                } while(!CT.setCustomerID(id));

                while(true) {
                    System.out.printf("Want to Add? (Y/N) : ");
                    answer = sc.next().toUpperCase().charAt(0);
                    if (answer == 'Y') {
                        DB.customers.getCustomers()[num].setCustomerID(id);
                        System.out.println("\n");
                        break;
                    }
                    else if (answer == 'N') {
                        System.out.println("\n");
                        break;
                    }
                    else {
                        System.out.println("\nfuck\n");
                    }
                }
                break;
            case 3:
                int time;
                do {
                    System.out.println("Before : " + DB.customers.getCustomers()[num].getUseTime());
                    System.out.printf("Enter Use Time (Exceeding zero) : ");
                    time = sc.nextInt();
                } while(!CT.setUseTime(time));

                while(true) {
                    System.out.printf("Want to Add? (Y/N) : ");
                    answer = sc.next().toUpperCase().charAt(0);
                    if (answer == 'Y') {
                        DB.customers.getCustomers()[num].setUseTime(time);
                        System.out.println("\n");
                        break;
                    }
                    else if (answer == 'N') {
                        System.out.println("\n");
                        break;
                    }
                    else {
                        System.out.println("\nfuck\n");
                    }
                }
                break;
            case 4:
                long payment;
                do {
                    System.out.println("Before : " + DB.customers.getCustomers()[num].getPaymentAmount());
                    System.out.printf("Enter Payment Of Amount (Exceeding zero) : ");
                    payment = sc.nextLong();
                } while(!CT.setPaymentAmount(payment));

                while(true) {
                    System.out.printf("Want to Add? (Y/N) : ");
                    answer = sc.next().toUpperCase().charAt(0);
                    if (answer == 'Y') {
                        DB.customers.getCustomers()[num].setPaymentAmount(payment);
                        System.out.println("\n");
                        break;
                    }
                    else if (answer == 'N') {
                        System.out.println("\n");
                        break;
                    }
                    else {
                        System.out.println("\nfuck\n");
                    }
                }
                break;
        }
    }

    private static void viewCustomerData() {
        System.out.printf("[ %s ]\n","View Customer Data");
        System.out.println("============================================================================================================");
        System.out.printf("| %12s | %20s | %20s | %20s | %20s |\n", "Customer Num", "Customer Name", "Customer ID", "Use Time", "Payment Of Amount");
        System.out.println("============================================================================================================");
        if(DB.customers.elementNum() == 0) {
            System.out.printf("| %-102s |\n","!!!No Customer Data!!!");
        }
        else {
            for (int i = 0; i < DB.customers.elementNum(); i++) {
                System.out.printf("| %12s | %20s | %20s | %20s | %20s |\n", DB.customers.getCustomers()[i].getCustomerNum(), DB.customers.getCustomers()[i].getCustomerName(), DB.customers.getCustomers()[i].getCustomerID(), DB.customers.getCustomers()[i].getUseTime(), DB.customers.getCustomers()[i].getPaymentAmount());
            }
        }
        System.out.println("============================================================================================================");
        System.out.printf("Enter Any Key To Exit : ");
        sc.next();
        System.out.println("\n");
    }

    private static void addCustomerData() {
        Customer CM = new Customer();
        Character answer;
        String name, id;
        int time;
        long payment;
        System.out.printf("[ %s ]\n","Add Customer Data");
        System.out.println("========================================================================");
        do {
            System.out.printf("Enter Name (Only English Characters With Spaces [length: 3 ~ 20]) : ");
            name = sc.next();
        } while (!CM.setCustomerName(name));
        do {
            System.out.printf("Enter ID (English Letters And Numbers Only [length: 5 ~ 12]) : ");
            id = sc.next();
        } while (!CM.setCustomerID(id));
        do {
            System.out.printf("Enter Use Time (Exceeding zero) : ");
            time = sc.nextInt();
        } while (!CM.setUseTime(time));
        do {
            System.out.printf("Enter Payment Of Amount (Exceeding zero) : ");
            payment = sc.nextLong();
        } while (!CM.setPaymentAmount(payment));
        System.out.println("\n=============================================================================================");
        System.out.printf("| %20s | %20s | %20s | %20s |\n", "Customer Name", "Customer ID", "Use Time", "Payment Of Amount");
        System.out.println("=============================================================================================");
        System.out.printf("| %20s | %20s | %20s | %20s |\n", name, id, time, payment);
        System.out.println("=============================================================================================");
        while(true) {
            System.out.printf("Want to Add? (Y/N) : ");
            answer = sc.next().toUpperCase().charAt(0);
            if (answer == 'Y') {
                CM.setCustomerNum(DB.total++);
                DB.customers.add(CM);
                System.out.println("\n");
                break;
            }
            else if (answer == 'N') {
                System.out.println("\n");
                break;
            }
            else {
                System.out.println("\nfuck\n");
            }
        }
    }
}
