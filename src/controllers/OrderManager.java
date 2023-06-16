package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import models.Flower;
import models.Order;

public class OrderManager {

    public ArrayList<Order> readOrders() {
        BufferedReader reader = null;
        ArrayList<Order> list = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader("orders.dat"));
            String line;
            while ((line = reader.readLine()) != null) {
                ArrayList<String> listF = new ArrayList<>();
                String[] fields = line.split(",");
                for (int i = 4; i < fields.length; i++) {
                    listF.add(fields[i]);
                }
                Order od = new Order(fields[0], fields[1], Double.parseDouble(fields[2]), fields[3], listF);
                list.add(od);
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

    public void removeOrder() {
        Scanner s = new Scanner(System.in);
        ArrayList<Order> listOrder = readOrders();
        BufferedWriter writer = null;
        int check = 0;
        try {
            System.out.println("Enter ID to remove: ");
            String idFind = s.nextLine().trim();
            for (int i = 0; i < listOrder.size(); i++) {
                if (idFind.equals(listOrder.get(i).getOrderID())) {
                    check = 1;
                    listOrder.remove(i);
                    System.out.println("Remove order successfully");
                    writer = new BufferedWriter(new FileWriter("orders.dat"));
                    for (i = 0; i < listOrder.size(); i++) {
                        writer.write(listOrder.get(i).getOrderID() + "," + listOrder.get(i).getDate() + "," + listOrder.get(i).getTotalPrice() + ","
                                + listOrder.get(i).getCustomerID());
                        for (int j = 0; j < listOrder.get(i).getFlowerList().size(); j++) {
                            writer.write("," + listOrder.get(i).getFlowerList().get(j));
                        }
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

    public void viewOrder(String accountID) {
        ArrayList<Order> list = readOrders();
        FlowerManager flw = new FlowerManager();
        ArrayList<Flower> listFlower = flw.readFlower();

        System.out.println("####################################################################");
        System.out.printf("#%20s#%20s#%24s#\n", "Order ID", "Date", "BuyerID");
        System.out.println("####################################################################");
        for (int i = list.size() - 1; i >= 0; i--) {
            if (accountID.equals(list.get(i).getCustomerID())) {
                System.out.printf("#%20s#%20s#%24s#\n", list.get(i).getOrderID(), list.get(i).getDate(), list.get(i).getCustomerID());
                break;
            }
        }
        System.out.println("####################################################################");
        System.out.printf("#%20s#%20s#%24s#\n", "Flower Name", "Quantity", "Price");
        System.out.println("####################################################################");
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        for (int i = list.size() - 1; i >= 0; i--) {
            if (accountID.equals(list.get(i).getCustomerID())) {
                for (int j = 0; j < list.get(i).getFlowerList().size(); j++) {
                    String[] fields = list.get(i).getFlowerList().get(j).split(":");
                    for (int k = 0; k < listFlower.size(); k++) {
                        if (fields[0].equals(listFlower.get(k).getFlowerID())) {
                            System.out.printf("#%20s#%20s#%24s#\n", listFlower.get(k).getName(), fields[1], decimalFormat.format(Double.parseDouble(fields[2])));
                        }
                    }
                }
                break;
            }
        }
        System.out.println("####################################################################");
        for (int i = list.size() - 1; i >= 0; i--) {
            if (accountID.equals(list.get(i).getCustomerID())) {
                System.out.println("#" + String.format("%67s", "TOTAL: " + decimalFormat.format(list.get(i).getTotalPrice()) + "#"));
                break;
            }
        }
        System.out.println("####################################################################");
    }

    public void writeOrder(ArrayList<Order> list) {
        Scanner s = new Scanner(System.in);
        BufferedWriter writer = null;
        try {
            for (int i = 0; i < list.size(); i++) {
                writer = new BufferedWriter(new FileWriter("orders.dat"));
                for (i = 0; i < list.size(); i++) {
                    writer.write(list.get(i).getOrderID() + "," + list.get(i).getDate() + "," + list.get(i).getTotalPrice() + ","
                            + list.get(i).getCustomerID());
                    for (int j = 0; j < list.get(i).getFlowerList().size(); j++) {
                        writer.write("," + list.get(i).getFlowerList().get(j));
                    }
                    writer.newLine();
                }
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

    public void addFlowerToCart(String accountID) {
        ArrayList<Order> list = readOrders();
        ArrayList<String> listOrderFlower = new ArrayList<>();
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String date = localDate.format(formatter);
        Double totalPrice = 0.0;
        for (int i = list.size() - 1; i > 0; i--) {
            if (accountID.equals(list.get(i).getCustomerID())
                    && date.equals(list.get(i).getDate())) {
                listOrderFlower = list.get(i).getFlowerList();
                listOrderFlower.add(addOrder());
                list.get(i).setFlowerList(listOrderFlower);
                for (int j = 0; j < list.get(i).getFlowerList().size(); j++) {
                    String[] fields = list.get(i).getFlowerList().get(j).split(":");
                    totalPrice += Double.parseDouble(fields[2]);
                }
                list.get(i).setTotalPrice(totalPrice);
                writeOrder(list);
                break;
            } else if (accountID.equals(list.get(i).getCustomerID())
                    && !date.equals(list.get(i).getDate())) {
                String orderID = "O00" + list.size();
                listOrderFlower.add(addOrder());
                for (int j = 0; j < list.get(i).getFlowerList().size(); j++) {
                    String[] fields = list.get(i).getFlowerList().get(j).split(":");
                    totalPrice += Double.parseDouble(fields[2]);
                }
                list.add(new Order(orderID, date, totalPrice, accountID, listOrderFlower));
                writeOrder(list);
                break;
            }
        }

    }

    public String addOrder() {
        FlowerManager flw = new FlowerManager();
        ArrayList<Flower> listFlw = flw.readFlower();
        Scanner s = new Scanner(System.in);
        System.out.print("Enter flower ID FXXX: ");
        String flowerID = s.nextLine().trim();
        System.out.print("Enter quantities: ");
        int quantity = Integer.parseInt(s.nextLine().trim());
        Double totalPrice = 0.0;

        for (int i = 0; i < listFlw.size(); i++) {
            if (flowerID.equals(listFlw.get(i).getFlowerID())) {
                totalPrice = listFlw.get(i).getUnitPrice() * quantity;
                return listFlw.get(i).getFlowerID() + ":" + quantity + ":" + totalPrice;
            }
        }
        return null;
    }

}
