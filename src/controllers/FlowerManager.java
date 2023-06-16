package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import models.Flower;

public class FlowerManager {

    public void addFlower() {
        ArrayList<Flower> list = readFlower();
        list.add(addFlw());
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("flowers.dat"));
            for (int i = 0; i < list.size(); i++) {
                writer.write(list.get(i).getFlowerID() + "," + list.get(i).getName() + "," + list.get(i).getUnitPrice() + "," + list.get(i).getImportDate());
                writer.newLine();
            }
            System.out.println("Successfully add the flower");  
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

    public String checkIDExist() {
        Scanner s = new Scanner(System.in);
        ArrayList<Flower> list = readFlower();

        while (true) {
            String id = "";
            try {
                System.out.println("Enter id: ");
                id = s.nextLine().trim();
                for (int i = 0; i < list.size(); i++) {
                    if (id.equals(list.get(i).getFlowerID())) {
                        throw new Exception();
                    }
                }
                return id;
            } catch (Exception e) {
                System.err.println("Duplicated ID");
            }
        }
    }

    public Flower addFlw() {
        Scanner s = new Scanner(System.in);
        String id = checkIDExist();
        System.out.print("Enter name: ");
        String name = s.nextLine();
        System.out.print("Enter price: ");
        double price = Double.parseDouble(s.nextLine().trim());
        System.out.print("Enter date: ");
        String date = s.nextLine();                 
        return new Flower(id, name, price, date);

    }

    public ArrayList<Flower> readFlower() {
        BufferedReader reader = null;
        ArrayList<Flower> list = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader("flowers.dat"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Flower flw = new Flower(fields[0], fields[1], Double.parseDouble(fields[2]), fields[3]);
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

    public void viewFlowerList() {
        ArrayList<Flower> list = readFlower();
        System.out.println("####################################################################");
        System.out.printf("#%-15s%-15s%-15s%-15s\n", "          id#", "          name#", "          price#", "          importDate#");
        System.out.println("####################################################################");
        list.forEach(System.out::println);
        System.out.println("####################################################################");
        System.out.println("#                                           TOTAL: " + list.size() + " flower type[s]#");
        System.out.println("####################################################################");
    }

    public void modifyFlower() {
        Scanner s = new Scanner(System.in);
        ArrayList<Flower> list = readFlower();
        BufferedWriter writer = null;
        int check = 0;
        try {
            System.out.println("Enter ID to modify: ");
            String idFind = s.nextLine().trim();
            for (int i = 0; i < list.size(); i++) {
                if (idFind.equals(list.get(i).getFlowerID())) {
                    check = 1;
                    System.out.println("Enter name: ");
                    String name = s.nextLine().trim();
                    list.get(i).setName(name);
                    System.out.println("Enter price: ");
                    double price = Double.parseDouble(s.nextLine().trim());
                    list.get(i).setUnitPrice(price);
                    System.out.println("Enter date: ");
                    String date = s.nextLine().trim();
                    list.get(i).setImportDate(date);
                    System.out.println("Modify flower successfully");
                    writer = new BufferedWriter(new FileWriter("flowers.dat"));
                    for (i = 0; i < list.size(); i++) {
                        writer.write(list.get(i).getFlowerID() + "," + list.get(i).getName() + "," + list.get(i).getUnitPrice() + "," + list.get(i).getImportDate());
                        writer.newLine();
                    }
                }
            }
            if (check == 0) {
                System.out.println("ID not exist");
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

    public void removeFlower() {
        Scanner s = new Scanner(System.in);
        ArrayList<Flower> list = readFlower();
        BufferedWriter writer = null;
        int check = 0;
        try {
            System.out.println("Enter ID to remove: ");
            String idFind = s.nextLine().trim();
            for (int i = 0; i < list.size(); i++) {
                if (idFind.equals(list.get(i).getFlowerID())) {
                    check = 1;
                    list.remove(i);
                    System.out.println("Remove flower successfully");
                    writer = new BufferedWriter(new FileWriter("flowers.dat"));
                    for (i = 0; i < list.size(); i++) {
                        writer.write(list.get(i).getFlowerID() + "," + list.get(i).getName() + "," + list.get(i).getUnitPrice() + "," + list.get(i).getImportDate());
                        writer.newLine();
                    }
                }
            }
            if (check == 0) {
                System.out.println("ID not exist");
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
