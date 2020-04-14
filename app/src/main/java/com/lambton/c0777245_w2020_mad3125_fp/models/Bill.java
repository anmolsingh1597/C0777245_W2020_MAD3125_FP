package com.lambton.c0777245_w2020_mad3125_fp.models;

import java.io.Serializable;

public class Bill implements Serializable {
    String custId;
    String id;
    String date;
    String billType;
    String billAmount;

    public Bill(String custId, String id, String date, String billType, String billAmount) {
        this.custId = custId;
        this.id = id;
        this.date = date;
        this.billType = billType;
        this.billAmount = billAmount;
    }

    public Bill() {
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(String billAmount) {
        this.billAmount = billAmount;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "custId='" + custId + '\'' +
                ", id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", billType='" + billType + '\'' +
                ", billAmount='" + billAmount + '\'' +
                '}';
    }
}
