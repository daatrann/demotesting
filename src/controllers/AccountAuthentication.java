package controllers;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AccountAuthentication {

    public String checkPassword() {
        Scanner s = new Scanner(System.in);
        while (true) {
            String pass = "";
            try {
                System.out.print("Enter password: ");
                pass = s.nextLine().trim();
                if(!containsSpecialCharacter(pass) || pass.length()<8){
                    throw new Exception();
                }
                return pass;
            } catch (Exception e) {
                System.err.println("Password must be at least 8 characters comprised by at least one character, one digit, and one special symbol");
            }
        }
    }
    
    public String checkUser() {
        Scanner s = new Scanner(System.in);
        while (true) {
            String user = "";
            try {
                System.out.print("Enter id AXXX: ");
                user = s.nextLine().trim();
                if(user.charAt(0) != 'A' || user.length()>4){
                    throw new Exception();
                }
                return user;
            } catch (Exception e) {
            }
        }
    }
    
    public static boolean containsSpecialCharacter(String pass) {
        String specialCharacterPattern = "[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]";

        Pattern pattern = Pattern.compile(specialCharacterPattern);

        Matcher matcher = pattern.matcher(pass);

        return matcher.find();
    }
}
