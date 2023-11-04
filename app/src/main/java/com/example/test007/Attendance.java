package com.example.test007;

public class Attendance {
    private int AID ;
    private String name ;
    private String email ;
    private String date ;

    public Attendance(int AID, String name, String email, String date) {
        this.AID = AID;
        this.name = name;
        this.email = email;
        this.date = date;
    }

    public Attendance(String name, String email, String date) {
        this.name = name;
        this.email = email;
        this.date = date;
    }

    public int getAID() {
        return AID;
    }

    public void setAID(int AID) {
        this.AID = AID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
