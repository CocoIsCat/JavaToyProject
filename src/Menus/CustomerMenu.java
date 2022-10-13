package Menus;

import java.util.Scanner;

import static Menus.MainMenu.printMainMenus;

public class CustomerMenu extends Menu{
    public static void printCustomerMenus() {
        int menu = 0;
        System.out.printf("[ %s ]\n","Manage Customer");
        System.out.println("========================================================================");
        System.out.printf("|%-70s|\n"," 1. Add Customer Data");
        System.out.printf("|%-70s|\n"," 2. View Customer Data");
        System.out.printf("|%-70s|\n"," 3. Update Customer Data");
        System.out.printf("|%-70s|\n"," 4. Delete Customer Data");
        System.out.printf("|%-70s|\n"," 5. Back");
        System.out.println("========================================================================");
        System.out.printf("Choose One : ");
        menu = new Scanner(System.in).nextInt();
        System.out.println("\n");
        chooseCustomerMenu(menu);
    }

    private static void chooseCustomerMenu(int menu) {
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
            default:
                printMainMenus();
        }
    }
}
