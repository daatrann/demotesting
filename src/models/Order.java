package models;

import java.util.ArrayList;

public class Order {
    private String orderID;
    private String date;
    private double totalPrice;
    private String customerID;
    private ArrayList<String> flowerList;

    public Order() {
    }

    public Order(String orderID, String date, double totalPrice, String customerID, ArrayList<String> flowerList) {
        this.orderID = orderID;
        this.date = date;
        this.totalPrice = totalPrice;
        this.customerID = customerID;
        this.flowerList = flowerList;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public ArrayList<String> getFlowerList() {
        return flowerList;
    }

    public void setFlowerList(ArrayList<String> flowerList) {
        this.flowerList = flowerList;
    }

    @Override
    public String toString() {
        return "orderID=" + orderID + ", date=" + date + ", totalPrice=" + totalPrice + ", customerID=" + customerID + ", flowerList=" + flowerList;
    }
    
    
}
