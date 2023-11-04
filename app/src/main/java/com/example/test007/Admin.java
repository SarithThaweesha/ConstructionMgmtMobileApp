package com.example.test007;

public class Admin {
    private String name ;
    private String address ;
    private int age ;
    private String gender ;
    private String username ;
    private String password ;
    private String email ;
    //private String role;



    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Admin(String name, String address, int age, String gender, String username, String password, String email) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.username = username;
        this.password = password;
        this.email = email;
        //this.role=role;
    }

    public Admin() {
        this.name = "";
        this.address = "";
        this.age = 0;
        this.gender = "";
        this.username = "";
        this.password = "";
        this.email = "";
        //this.role="";
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
