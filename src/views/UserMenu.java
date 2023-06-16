package views;

import controllers.BaseManager;
import controllers.CustomerManager;
import controllers.FlowerManager;
import controllers.OrderManager;
import java.util.Scanner;
                 
public class UserMenu {                                                                                                     
    public void showMenuUser(String accountID){                                                                                 
        Scanner s = new Scanner(System.in);
        FlowerManager flowerManager = new FlowerManager();
        OrderManager orderManager = new OrderManager();    
        CustomerManager customerManager = new CustomerManager();
        BaseManager baseMagager = new BaseManager();
        while(true){
            System.out.println("USER MENU:");
            System.out.println("1-Update Profile");
            System.out.println("2-View Flower List");
            System.out.println("3-Add Flower To Card");
            System.out.println("4-View Order");
            System.out.println("5-Cancel Order");
            System.out.println("6-Quit");
            System.out.print("Enter your choice:");
            int choice = Integer.parseInt(s.nextLine().trim());
            switch (choice) {
                case 1:
                    customerManager.updateProfile(accountID);
                    break;
                case 2:
                    flowerManager.viewFlowerList();
                    break;
                case 3:
                    orderManager.addFlowerToCart(accountID);
                    break;
                case 4:
                    orderManager.viewOrder(accountID);
                    break;
                case 5:
                    break;
                case 6:
                    baseMagager.saveQuit();
                    System.exit(0);
            }            
            
        }
    }
}
