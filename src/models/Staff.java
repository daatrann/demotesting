package models;

public class Staff {
    private String staffID;
    private String name;
    private String address;
    private String phone;

    public Staff() {
    }
    
    

    public Staff(String staffID, String name, String address, String phone) {
        this.staffID = staffID;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
