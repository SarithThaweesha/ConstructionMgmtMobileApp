package com.example.test007;

public class Construction {
    private int CSID ;
    private String nameC ;
    private String addressC ;
    private String supervisorN ;
    private String workers ;
    private String budget ;
    private String duration ;

    public Construction(int CSID, String nameC, String addressC, String supervisorN, String workers, String budget, String duration) {
        this.CSID = CSID;
        this.nameC = nameC;
        this.addressC = addressC;
        this.supervisorN = supervisorN;
        this.workers = workers;
        this.budget = budget;
        this.duration = duration;
    }

    public Construction(String nameC, String addressC, String supervisorN, String workers, String budget, String duration) {
        this.nameC = nameC;
        this.addressC = addressC;
        this.supervisorN = supervisorN;
        this.workers = workers;
        this.budget = budget;
        this.duration = duration;
    }

    public Construction() {
    }

    public int getCSID() {
        return CSID;
    }

    public void setCSID(int CSID) {
        this.CSID = CSID;
    }

    public String getNameC() {
        return nameC;
    }

    public void setNameC(String nameC) {
        this.nameC = nameC;
    }

    public String getAddressC() {
        return addressC;
    }

    public void setAddressC(String addressC) {
        this.addressC = addressC;
    }

    public String getSupervisorN() {
        return supervisorN;
    }

    public void setSupervisorN(String supervisorN) {
        this.supervisorN = supervisorN;
    }

    public String getWorkers() {
        return workers;
    }

    public void setWorkers(String workers) {
        this.workers = workers;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
