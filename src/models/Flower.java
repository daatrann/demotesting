package models;

public class Flower {

    private String flowerID;
    private String name;
    private double unitPrice;
    private String importDate;

    public Flower() {
    }

    public Flower(String flowerID, double unitPrice) {
        this.flowerID = flowerID;
        this.unitPrice = unitPrice;
    }

    public Flower(String flowerID, String name, double unitPrice, String importDate) {
        this.flowerID = flowerID;
        this.name = name;
        this.unitPrice = unitPrice;
        this.importDate = importDate;
    }

    public String getFlowerID() {
        return flowerID;
    }

    public void setFlowerID(String flowerID) {
        this.flowerID = flowerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }

    @Override
    public String toString() {
        return "#" + String.format("%13s%17s%16s%21s", flowerID + "#", name + "#", unitPrice + "#", importDate + "#");
    }

}
