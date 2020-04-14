package com.lambton.c0777245_w2020_mad3125_fp.models;

public class Mobile extends Bill {
    String mobileManufacturer;
    String planName;
    String mobileNumber;
    String internetGb;
    String minutes;

    public Mobile(String custId, String id, String date, String billType, String billAmount, String mobileManufacturer, String planName, String mobileNumber, String internetGb, String minutes) {
        super(custId, id, date, billType, billAmount);
        this.mobileManufacturer = mobileManufacturer;
        this.planName = planName;
        this.mobileNumber = mobileNumber;
        this.internetGb = internetGb;
        this.minutes = minutes;
    }

    public Mobile(String mobileManufacturer, String planName, String mobileNumber, String internetGb, String minutes) {
        this.mobileManufacturer = mobileManufacturer;
        this.planName = planName;
        this.mobileNumber = mobileNumber;
        this.internetGb = internetGb;
        this.minutes = minutes;
    }

    public String getMobileManufacturer() {
        return mobileManufacturer;
    }

    public void setMobileManufacturer(String mobileManufacturer) {
        this.mobileManufacturer = mobileManufacturer;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getInternetGb() {
        return internetGb;
    }

    public void setInternetGb(String internetGb) {
        this.internetGb = internetGb;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

}
