package controllers;

import java.util.Scanner;

public class BaseManager {
    public void saveQuit(){
        while(true){
        Scanner s = new Scanner(System.in);
        System.out.println("Do you want to save data[1/0-Y/N-T/F]: ");       
        String choice = s.nextLine().trim();
        if(choice.equalsIgnoreCase("T") || choice.equalsIgnoreCase("F") 
                || choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N")
                || choice.equals("1") || choice.equals("0")){
            System.out.println("Successfully save data");
            System.out.println("Successfully logout");
            break;
        }
        }
    }

}
                                    