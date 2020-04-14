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

}
