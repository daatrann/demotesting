package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import models.Account;
import models.Login;
import views.DevMenu;
import views.UserMenu;

public class AccountManager {
        public void checkLogin(Login account) {
        BufferedReader reader = null;
        ArrayList<Account> list = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader("accounts.dat"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Account acc = new Account(fields[0], fields[1], fields[2], fields[3]);
                list.add(acc);
            }
            for (int i = 0; i < list.size(); i++) {
                if (account.getId().equals(list.get(i).getAccountID())
                        && account.getPassword().equals(list.get(i).getPassword())) {
                    if (list.get(i).getRole().equals("USER")) {
                        System.out.println("Successfully login");
                        UserMenu u = new UserMenu();
                        u.showMenuUser(list.get(i).getStaffID());
                    } else {
                        DevMenu d = new DevMenu();
                        d.showMenuDev(list.get(i).getStaffID());
                    }
                }
            }
        } catch (IOException e) {
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
    }
}
