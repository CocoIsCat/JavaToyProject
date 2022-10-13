package Menus;

import java.util.Scanner;

public class MainMenu extends Menu{
    public static void printMainMenus() {
        int menu = 0;
        System.out.printf("[ %s ]\n","Main Menu");
        System.out.println("========================================================================");
        System.out.printf("|%-70s|\n"," 1. Manage Group");
        System.out.printf("|%-70s|\n"," 2. Manege Customer");
        System.out.printf("|%-70s|\n"," 3. Summary");
        System.out.printf("|%-70s|\n"," 4. Quit");
        System.out.println("========================================================================");
        System.out.printf(" Choose One : ");
        menu = new Scanner(System.in).nextInt();
        System.out.println("\n");
        chooseMainMenu(menu);
    }

    private static void chooseMainMenu(int menu) {
        switch (menu) {
            case 1:
                GroupMenu.printGroupMenus();
                break;
            case 2:
                CustomerMenu.printCustomerMenus();
                break;
            case 3:
                SummaryMenu.printSummaryMenus();
                break;
            case 4:
                break;
            default:
                printMainMenus();
        }
    }
}
