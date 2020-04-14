package com.lambton.c0777245_w2020_mad3125_fp.models;

public class Internet extends Bill {
    String internetGb;
    String providerName;

    public Internet(String custId, String id, String date, String billType, String billAmount, String internetGb, String providerName) {
        super(custId, id, date, billType, billAmount);
        this.internetGb = internetGb;
        this.providerName = providerName;
    }

    public Internet(String internetGb, String providerName) {
        this.internetGb = internetGb;
        this.providerName = providerName;
    }

    public String getInternetGb() {
        return internetGb;
    }

    public void setInternetGb(String internetGb) {
        this.internetGb = internetGb;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    @Override
    public String toString() {
        return "Internet{" +
                "internetGb='" + internetGb + '\'' +
                ", providerName='" + providerName + '\'' +
                ", custId='" + custId + '\'' +
                ", id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", billType='" + billType + '\'' +
                ", billAmount='" + billAmount + '\'' +
                '}';
    }
}
