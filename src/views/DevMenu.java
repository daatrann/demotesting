package views;

import controllers.BaseManager;
import controllers.FlowerManager;
import controllers.OrderManager;
import controllers.StaffManager;
import java.util.Scanner;

public class DevMenu {

    public void showMenuDev(String accountID) {
        Scanner s = new Scanner(System.in);
        FlowerManager flowerManager = new FlowerManager();
        OrderManager orderManager = new OrderManager();
        StaffManager staffManager = new StaffManager();
        BaseManager baseMagager = new BaseManager();
        while (true) {
            System.out.println("DEV MENU:");
            System.out.println("1-Update Profile");
            System.out.println("2-View Flower List");
            System.out.println("3-Add Flower");
            System.out.println("4-Modify Order");
            System.out.println("5-Remove Flower");
            System.out.println("6-View Sorted Order");
            System.out.println("7-Remove Order");
            System.out.println("8-Quit");
            System.out.println("Enter your choice:");
            int choice = Integer.parseInt(s.nextLine().trim());
            switch (choice) {
                case 1:
                    staffManager.updateProfile(accountID);
                    break;
                case 2:
                    flowerManager.viewFlowerList();
                    break;
                case 3:
                    flowerManager.addFlower();
                    break;
                case 4:
                    flowerManager.modifyFlower();
                    break;
                case 5:
                    flowerManager.removeFlower();
                    break;
                case 6:
                    break;
                case 7:
                    orderManager.removeOrder();
                    break;
                case 8:
                    baseMagager.saveQuit();
                    System.exit(0);
            }
        }
    }
}
