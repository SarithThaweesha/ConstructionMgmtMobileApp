package com.example.test007;

public class Supervisor {
    private int SID ;
    private String name ;
    private String birth ;
    private String address ;
    private String username ;
    private String password ;
    private String phone ;
    private String nic ;
    private String email ;
    //private String role ;

    public Supervisor(String name, String birth, String address, String username, String password, String phone, String nic, String email) {
        this.name = name;
        this.birth = birth;
        this.address = address;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.nic = nic;
        this.email = email;
    }

    public Supervisor(int SID, String name, String birth, String address, String username, String password, String phone, String nic, String email) {
        this.SID=SID;
        this.name = name;
        this.birth = birth;
        this.address = address;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.nic = nic;
        this.email = email;
        //this.role = role;
    }



    public Supervisor(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Supervisor() {
        this.SID=0;
        this.name = "";
        this.birth = "";
        this.address = "";
        this.username = "";
        this.password = "";
        this.phone = "";
        this.nic = "";
        this.email = "";
        //this.role = "";
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public int getSID() {
        return SID;
    }

    public void setSID(int SID) {
        this.SID = SID;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
