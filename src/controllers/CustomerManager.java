package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import models.Customer;

public class CustomerManager {
    public void updateStaff(Customer c) {
        Scanner s = new Scanner(System.in);
        ArrayList<Customer> list = readCustomer();
        BufferedWriter writer = null;
        int check = 0;
        try {
            for (int i = 0; i < list.size(); i++) {
                if (c.getCustomerID().equals(list.get(i).getCustomerID())) {
                    check = 1;
                    list.get(i).setName(c.getName());
                    list.get(i).setAddress(c.getAddress());
                    list.get(i).setPhone(c.getPhone());
                    System.out.println("Successfully update account");
                    writer = new BufferedWriter(new FileWriter("customers.dat"));
                    for (i = 0; i < list.size(); i++) {
                        writer.write(list.get(i).getCustomerID()+ "," + list.get(i).getName() + "," + list.get(i).getAddress()+ "," + list.get(i).getPhone());
                        writer.newLine();
                    }
                }
            }
            if (check == 0) {
                System.out.println("Something wrong by ID");
            }
        } catch (IOException e) {
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
            }
        }
    }
    
        public void updateProfile(String accountID) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = s.nextLine().trim();
        System.out.print("Enter address: ");
        String address = s.nextLine().trim();
        System.out.print("Enter phone number: ");
        String phone = s.nextLine();
        Customer c = new Customer(accountID, name, address, phone);
        updateStaff(c);
        
    }
    
    public ArrayList<Customer> readCustomer() {
        BufferedReader reader = null;
        ArrayList<Customer> list = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader("customers.dat"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Customer c = new Customer(fields[0], fields[1], fields[1], fields[3]);
                list.add(c);
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
        return list;
    }
    

}
