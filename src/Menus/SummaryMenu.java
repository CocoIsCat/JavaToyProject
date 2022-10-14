package Menus;

import Database.DB;

import java.util.Scanner;

public class SummaryMenu extends Menu{
    static String[] GN = {"VVIP", "VIP", "GENERAL", "NORMAL"};
    public static void printSummaryMenus() {
        while(true) {
            int menu = 0;
            System.out.printf("[ %s ]\n", "Manage Customer");
            System.out.println("========================================================================");
            System.out.printf("|%-70s|\n", " 1. Print All Customers");
            System.out.printf("|%-70s|\n", " 2. Print All Customers(Sorted By Name)");
            System.out.printf("|%-70s|\n", " 3. Print All Customers(Sorted By Spent Time)");
            System.out.printf("|%-70s|\n", " 4. Print All Customers(Sorted By Total Payment)");
            System.out.printf("|%-70s|\n", " 5. Back");
            System.out.println("========================================================================");
            System.out.printf("Choose One : ");
            menu = new Scanner(System.in).nextInt();
            if (menu == 5) {
                System.out.println("\n");
                break;
            }
            else if(menu > 5 || menu < 1) {
                System.out.println("\n!!!Invalid Input!!!\n");
            }
            else {
                System.out.println("\n");
                chooseSummaryMenu(menu);
            }
        }
    }

    private static void chooseSummaryMenu(int menu) {
        switch (menu) {
            case 1:
                printAllCustomers();
                break;
            case 2:
                printSortNameCustomers();
                break;
            case 3:
                printSortTimeCustomers();
                break;
            case 4:
                printSortSpentCustomers();
                break;
        }
    }

    private static void printSortSpentCustomers() {
        while (true) {
            int select;
            boolean isAscending = false, flag;
            System.out.printf("[ %s ]\n", "Print All Customers(Sorted By Use Time)");
            System.out.println("========================================================================");
            DB.groups.groupClassify(DB.customers);
            System.out.printf("| %-68s |\n", "Select Sort Type (Exit : Enter 0)");
            System.out.println("========================================================================");
            System.out.printf("| %20s %20s %-26s |\n", "1. Ascending", "", "2. Descending");
            System.out.println("========================================================================");
            System.out.printf("Choose One : ");
            select = sc.nextInt();
            if (select == 0) {
                System.out.println("\n");
                flag = false;
                break;
            } else if (select == 1) {
                System.out.println("\n");
                isAscending = true;
                flag = true;
            } else if (select == 2) {
                System.out.println("\n");
                isAscending = false;
                flag= true;
            } else {
                System.out.println("\n!!!Invalid Input!!!\n");
                flag = false;
            }
            if(flag) {
                for (int i = 0; i < 4; i++) {
                    DB.groups.getGroups()[i].getGroupMember().sortBySpend(isAscending);
                }
                printCustomers();
                System.out.printf("Enter Any Key To Exit : ");
                sc.next();
                System.out.println("\n");
            }
        }
    }

    private static void printSortTimeCustomers() {
        while (true) {
            int select;
            boolean isAscending = false, flag;
            System.out.printf("[ %s ]\n", "Print All Customers(Sorted By Use Time)");
            System.out.println("========================================================================");
            DB.groups.groupClassify(DB.customers);
            System.out.printf("| %-68s |\n", "Select Sort Type (Exit : Enter 0)");
            System.out.println("========================================================================");
            System.out.printf("| %20s %20s %-26s |\n", "1. Ascending", "", "2. Descending");
            System.out.println("========================================================================");
            System.out.printf("Choose One : ");
            select = sc.nextInt();
            if (select == 0) {
                System.out.println("\n");
                flag = false;
                break;
            } else if (select == 1) {
                System.out.println("\n");
                isAscending = true;
                flag = true;
            } else if (select == 2) {
                System.out.println("\n");
                isAscending = false;
                flag= true;
            } else {
                System.out.println("\n!!!Invalid Input!!!\n");
                flag = false;
            }
            if(flag) {
                for (int i = 0; i < 4; i++) {
                    DB.groups.getGroups()[i].getGroupMember().sortByTime(isAscending);
                }
                printCustomers();
                System.out.printf("Enter Any Key To Exit : ");
                sc.next();
                System.out.println("\n");
            }
        }
    }

    private static void printSortNameCustomers() {
        while (true) {
            int select;
            boolean isAscending = false, flag;
            System.out.printf("[ %s ]\n", "Print All Customers(Sorted By Name)");
            System.out.println("========================================================================");
            DB.groups.groupClassify(DB.customers);
            System.out.printf("| %-68s |\n", "Select Sort Type (Exit : Enter 0)");
            System.out.println("========================================================================");
            System.out.printf("| %20s %20s %-26s |\n", "1. Ascending", "", "2. Descending");
            System.out.println("========================================================================");
            System.out.printf("Choose One : ");
            select = sc.nextInt();
            if (select == 0) {
                System.out.println("\n");
                flag = false;
                break;
            } else if (select == 1) {
                System.out.println("\n");
                isAscending = true;
                flag = true;
            } else if (select == 2) {
                System.out.println("\n");
                isAscending = false;
                flag= true;
            } else {
                System.out.println("\n!!!Invalid Input!!!\n");
                flag = false;
            }
            if(flag) {
                for (int i = 0; i < 4; i++) {
                    DB.groups.getGroups()[i].getGroupMember().sortByName(isAscending);
                }
                printCustomers();
                System.out.printf("Enter Any Key To Exit : ");
                sc.next();
                System.out.println("\n");
            }
        }
    }

    private static void printAllCustomers() {
        System.out.printf("[ %s ]\n", "Print All Customers");
        System.out.println("========================================================================");
        DB.groups.groupClassify(DB.customers);
        printCustomers();
        System.out.printf("Enter Any Key To Exit : ");
        sc.next();
        System.out.println("\n");
    }

    private static void printCustomers() {
        for (int i = 0; i < 4; i++) {
            System.out.printf("\n%-11s %96s\n", "| " + GN[i] + " |", " Num : " + DB.groups.getGroups()[i].getGroupMember().elementNum());
            System.out.println("============================================================================================================");
            System.out.printf("| %12s | %20s | %20s | %20s | %20s |\n", "Customer Num", "Customer Name", "Customer ID", "Use Time", "Payment Of Amount");
            System.out.println("============================================================================================================");
            if(DB.groups.getGroups()[i].getGroupMember().elementNum() == 0) {
                System.out.printf("| %-104s |\n", "!!!No Customer Data!!!");
            }
            else {
                for (int j = 0; j < DB.groups.getGroups()[i].getGroupMember().elementNum(); j++) {
                    System.out.printf("| %12s | %20s | %20s | %20s | %20s |\n", DB.groups.getGroups()[i].getGroupMember().getCustomers()[j].getCustomerNum(), DB.groups.getGroups()[i].getGroupMember().getCustomers()[j].getCustomerName(), DB.groups.getGroups()[i].getGroupMember().getCustomers()[j].getCustomerID(), DB.groups.getGroups()[i].getGroupMember().getCustomers()[j].getUseTime(), DB.groups.getGroups()[i].getGroupMember().getCustomers()[j].getPaymentAmount());
                }
            }
            System.out.println("============================================================================================================");
        }
    }
}
