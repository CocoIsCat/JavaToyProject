package Menus;

import java.util.Scanner;

import static Menus.MainMenu.printMainMenus;

public class GroupMenu extends Menu{
    public static void printGroupMenus() {
        int menu = 0;
        System.out.println("======================================");
        System.out.printf("|%-36s|\n"," Manage Group");
        System.out.println("======================================");
        System.out.printf("|%-36s|\n"," 1. Set Parameter");
        System.out.printf("|%-36s|\n"," 2. View Parameter");
        System.out.printf("|%-36s|\n"," 3. Update Parameter");
        System.out.printf("|%-36s|\n"," 4. Back");
        System.out.println("======================================");
        System.out.printf("Choose One : ");
        menu = new Scanner(System.in).nextInt();
        System.out.println("======================================");
        System.out.println("\n");
        chooseGroupMenu(menu);
    }

    private static void chooseGroupMenu(int menu) {
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
