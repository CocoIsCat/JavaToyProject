package Menus;

import Database.DB;
import Group.GroupParameter;

public class GroupMenu extends Menu{

    static String[] GN = {"VVIP", "VIP", "GENERAL"};
    /*그룹을 관리하는 메뉴 출력*/
    public static void printGroupMenus() {
        while(true) {
            int menu = 0;
            System.out.printf("[ %s ]\n", "Manage Group");
            System.out.println("========================================================================");
            System.out.printf("|%-70s|\n", " 1. Set Parameter");
            System.out.printf("|%-70s|\n", " 2. View Parameter");
            System.out.printf("|%-70s|\n", " 3. Update Parameter");
            System.out.printf("|%-70s|\n", " 4. Back");
            System.out.println("========================================================================");
            System.out.printf("Choose One : ");
            menu = sc.nextInt();
            if (menu == 4) {
                System.out.println("\n");
                break;
            }
            else if(menu > 3 || menu < 1) {
                System.out.println("\n!!!Invalid Input!!!\n");
            }
            else {
                System.out.println("\n");
                chooseGroupMenu(menu);
            }
        }
    }

    /*printGroupMenu에서 선택한 메뉴에 따라 해당 기능 함수를 호출
    *
    * @param    menu printGroupMenu에서 선택한 메뉴
    * */
    private static void chooseGroupMenu(int menu) {
        switch (menu) {
            case 1:
                printSetParameter();
                break;
            case 2:
                printViewParameter();
                break;
            case 3:
                printUpdateParameter();
                break;
        }
    }

    /*그룹 파라미터를 업데이트하는 메뉴를 출력*/
    private static void printUpdateParameter() {
        while(true) {
            int group = 0;
            System.out.printf("[ %s ]\n", "Update Parameter");
            System.out.println("========================================================================");
            System.out.printf("|%-70s|\n", " Select a group to view parameter (Exit : Enter 0)");
            System.out.println("========================================================================");
            System.out.printf("| %s %29s %29s  |\n", "1. VVIP", "2. VIP", "3. GENERAL");
            System.out.println("========================================================================");
            System.out.printf("Choose Group : ");
            group = sc.nextInt();
            if (group == 0) {
                System.out.println("\n");
                break;
            }
            else if (group > 3 || group < 1) {
                System.out.println("\n!!!Invalid Input!!!\n");
            } else {
                System.out.println("\n");
                updateParameter(group);
            }
        }
    }

    /*printUpdateParameter 선택한 그룹의 파라미터를 보여줌
     *
     * @param    group printUpdateParameter에서 선택한 그룹
     * */
    private static void updateParameter(int group) {
        System.out.printf("[ %s ]\n", "Update Parameter Of " + GN[group - 1]);
        System.out.printf("%72s\n", " | Current |");
        int useTime = DB.groups.getGroups()[group - 1].getGroupParameter().getUseTime();
        int payment = DB.groups.getGroups()[group - 1].getGroupParameter().getPaymentOfAmount();
        GroupParameter GP = new GroupParameter();
        System.out.println("========================================================================");
        System.out.printf("| %20s | %21s | %21s |\n", "Group", "Use Time", "Payment Of Spent");
        System.out.println("========================================================================");
        System.out.printf("| %20s | %21s | %21s |\n", GN[group - 1], useTime, payment);
        System.out.println("========================================================================");
        do {
            System.out.printf("Enter Use Time (Exceeding zero) : ");
            useTime = sc.nextInt();
        } while (!GP.setUseTime(useTime));
        do {
            System.out.printf("Enter Payment Of Amount (Exceeding zero) : ");
            payment = sc.nextInt();
        } while (!GP.setPaymentOfAmount(payment));
        DB.groups.getGroups()[group - 1].setGroupParameter(GP);
        System.out.println("\n!!! " + GN[group - 1] + " Parameter Update Successful !!!\n");
    }

    /*그룹 파라미터를 보여주는 메뉴를 출력*/
    private static void printViewParameter() {
        while(true) {
            int group = 0;
            System.out.printf("[ %s ]\n", "View Parameter");
            System.out.println("========================================================================");
            System.out.printf("|%-70s|\n", " Select a group to view parameter (Exit : Enter 0)");
            System.out.println("========================================================================");
            System.out.printf("| %s %19s %20s %19s |\n", "1. VVIP", "2. VIP", "3. GENERAL", "4. ALL");
            System.out.println("========================================================================");
            System.out.printf("Choose Group : ");
            group = sc.nextInt();
            if (group == 0) {
                System.out.println("\n");
                break;
            }
            else if (group > 4 || group < 1) {
                System.out.println("\n!!!Invalid Input!!!\n");
            } else {
                System.out.println("\n");
                viewParameter(group);
            }
        }
    }

    /*printViewParameter에서 선택한 그룹의 파라미터를 보여줌
     *
     * @param    group printViewParameter에서 선택한 그룹
     * */
    private static void viewParameter(int group) {
        if(group == 4) {
            System.out.printf("[ %s ]\n", "View Parameter Of ALL");
            System.out.println("========================================================================");
            System.out.printf("| %20s | %21s | %21s |\n", "Group", "Use Time", "Payment Of Spent");
            System.out.println("========================================================================");
            for(int i = 0; i < group - 1; i++) {
                int useTime = DB.groups.getGroups()[i].getGroupParameter().getUseTime();
                int payment = DB.groups.getGroups()[i].getGroupParameter().getPaymentOfAmount();
                System.out.printf("| %20s | %21s | %21s |\n", GN[i], useTime, payment);
            }
            System.out.println("========================================================================");
            System.out.printf("Enter Any Key To Exit : ");
            if (sc.next() != null)
                System.out.println("\n");
        }
        else {
            int useTime = DB.groups.getGroups()[group - 1].getGroupParameter().getUseTime();
            int payment = DB.groups.getGroups()[group - 1].getGroupParameter().getPaymentOfAmount();
            System.out.printf("[ %s ]\n", "View Parameter of " + GN[group - 1]);
            System.out.println("========================================================================");
            System.out.printf("| %20s | %21s | %21s |\n", "Group", "Use Time", "Payment Of Spent");
            System.out.println("========================================================================");
            System.out.printf("| %20s | %21s | %21s |\n", GN[group - 1], useTime, payment);
            System.out.println("========================================================================");
            System.out.printf("Enter Any Key To Exit : ");
            if (sc.next() != null)
                System.out.println("\n");
        }
    }

    /*그룹 파라미터를 설정하는 메뉴를 출력*/
    private static void printSetParameter() {
        while(true) {
            int group = 0;
            System.out.printf("[ %s ]\n", "Set Parameter");
            System.out.println("========================================================================");
            System.out.printf("|%-70s|\n", " Select a group to set parameter (Exit : Enter 0)");
            System.out.println("========================================================================");
            System.out.printf("| %s %29s %29s  |\n", "1. VVIP", "2. VIP", "3. GENERAL");
            System.out.println("========================================================================");
            System.out.printf("Choose Group : ");
            group = sc.nextInt();
            if (group == 0) {
                System.out.println("\n");
                break;
            }
            else if (group > 3 || group < 1) {
                System.out.println("\n!!!Invalid Input!!!\n");
            } else {
                System.out.println("\n");
                setParameter(group);
            }
        }
    }

    /*printSetParameter에서 선택한 그룹의 파라미터를 설정
    *
    * @param    group printSetParameter에서 선택한 그룹
    * */
    private static void setParameter(int group) {
        GroupParameter GP = new GroupParameter();
        int useTime, paymentOfAmount;
        System.out.printf("[ %s ]\n","Set Parameter Of " + GN[group - 1]);
        System.out.println("========================================================================");
        do {
            System.out.printf("Enter Use Time (Exceeding zero) : ");
            useTime = sc.nextInt();
        } while (!GP.setUseTime(useTime));
        do {
            System.out.printf("Enter Payment Of Amount (Exceeding zero) : ");
            paymentOfAmount = sc.nextInt();
        } while (!GP.setPaymentOfAmount(paymentOfAmount));
        DB.groups.getGroups()[group - 1].setGroupParameter(GP);
        System.out.println("\n!!! " + GN[group - 1] + " Parameter Setup Successful !!!\n");
    }
}
