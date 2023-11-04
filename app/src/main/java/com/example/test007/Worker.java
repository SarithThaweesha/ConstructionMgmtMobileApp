package com.example.test007;

public class Worker {
    private int WID ;
    private String name ;
    private String address ;
    private String birthday ;
    private String role ;
    private String phone ;
    private String nic ;
    private String email ;

    public Worker(int WID,String name, String email) {
        this.WID = WID;
        this.name = name;
        this.email = email;
    }

    public Worker(int WID, String name, String address, String birthday, String phone, String nic, String email) {
        this.WID = WID;
        this.name = name;
        this.address = address;
        this.birthday = birthday;
        this.phone = phone;
        this.nic = nic;
        this.email = email;
    }

    public Worker(int WID, String name, String address, String birthday, String role, String phone, String nic, String email) {
        this.WID = WID;
        this.name = name;
        this.address = address;
        this.birthday = birthday;
        this.role = role;
        this.phone = phone;
        this.nic = nic;
        this.email = email;
    }

    public Worker(String name, String address, String birthday, String role, String phone, String nic, String email) {
        this.name = name;
        this.address = address;
        this.birthday = birthday;
        this.role = role;
        this.phone = phone;
        this.nic = nic;
        this.email = email;
    }

    public Worker() {
    }

    public int getWID() {
        return WID;
    }

    public void setWID(int WID) {
        this.WID = WID;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
