package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import models.Staff;


public class StaffManager {

    public void updateProfile(String accountID) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = s.nextLine().trim();
        System.out.print("Enter address: ");
        String address = s.nextLine().trim();
        System.out.print("Enter phone number: ");
        String phone = s.nextLine();
        Staff st = new Staff(accountID, name, address, phone);
        updateStaff(st);
        
    }
    
    public ArrayList<Staff> listStaff() {
        BufferedReader reader = null;
        ArrayList<Staff> list = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader("staffs.dat"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Staff flw = new Staff(fields[0], fields[1], fields[1], fields[3]);
                list.add(flw);
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
    
    public void updateStaff(Staff st) {
        Scanner s = new Scanner(System.in);
        ArrayList<Staff> list = listStaff();
        BufferedWriter writer = null;
        int check = 0;
        try {
            for (int i = 0; i < list.size(); i++) {
                if (st.getStaffID().equals(list.get(i).getStaffID())) {
                    check = 1;
                    list.get(i).setName(st.getName());
                    list.get(i).setAddress(st.getAddress());
                    list.get(i).setPhone(st.getPhone());
                    System.out.println("Update profile successfully");
                    writer = new BufferedWriter(new FileWriter("staffs.dat"));
                    for (i = 0; i < list.size(); i++) {
                        writer.write(list.get(i).getStaffID()+ "," + list.get(i).getName() + "," + list.get(i).getAddress()+ "," + list.get(i).getPhone());
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
    
    
    
    
    
}
