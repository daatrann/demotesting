package models;

public class Account {
    private String accountID;
    private String password;
    private String role;
    private String staffID;

    public Account() {
    }

    public Account(String accountID, String password, String role, String staffID) {
        this.accountID = accountID;
        this.password = password;
        this.role = role;
        this.staffID = staffID;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }
    
    
}
