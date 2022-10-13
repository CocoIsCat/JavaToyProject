package Menus;

import java.util.Scanner;

import static Menus.MainMenu.printMainMenus;

public class SummaryMenu extends Menu{
    public static void printSummaryMenus() {
        int menu = 0;
        System.out.println("======================================");
        System.out.printf("|%-36s|\n"," Manage Customer");
        System.out.println("======================================");
        System.out.printf("|%-36s|\n"," 1. Print All Customers");
        System.out.printf("|%-36s|\n"," 2. Print All Customers(Sorted By Name)");
        System.out.printf("|%-36s|\n"," 3. Print All Customers(Sorted By Spent Time)");
        System.out.printf("|%-36s|\n"," 4. Print All Customers(Sorted By Total Payment)");
        System.out.printf("|%-36s|\n"," 5. Back");
        System.out.println("======================================");
        System.out.printf("Choose One : ");
        menu = new Scanner(System.in).nextInt();
        System.out.println("======================================");
        System.out.println("\n");
        chooseSummaryMenu(menu);
    }

    private static void chooseSummaryMenu(int menu) {
        switch (menu) {
            case 1:
                GroupMenu.printGroupMenus();
                break;
            case 2:
                CustomerMenu.printCustomerMenus();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                printMainMenus();
        }
    }
}
