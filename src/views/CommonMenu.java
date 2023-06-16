package views;

import java.util.Scanner;
import models.Login;
import controllers.AccountAuthentication;
import controllers.AccountManager;

public class CommonMenu {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        AccountAuthentication auth = new AccountAuthentication();
        AccountManager am = new AccountManager();
        while(true){
            //check user requirments
            String user = auth.checkUser();
            //check password requirments
            String password = auth.checkPassword();
            Login account = new Login(user, password);
            am.checkLogin(account);
        }
    }
}
