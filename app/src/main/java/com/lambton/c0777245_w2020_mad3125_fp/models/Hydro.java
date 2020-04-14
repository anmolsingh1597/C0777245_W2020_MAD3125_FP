package com.lambton.c0777245_w2020_mad3125_fp.models;

public class Hydro extends Bill {
    String agencyName;
    String unitsConsumed;

    public Hydro(String custId, String id, String date, String billType, String billAmount, String agencyName, String unitsConsumed) {
        super(custId, id, date, billType, billAmount);
        this.agencyName = agencyName;
        this.unitsConsumed = unitsConsumed;
    }

    public Hydro(String agencyName, String unitsConsumed) {
        this.agencyName = agencyName;
        this.unitsConsumed = unitsConsumed;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getUnitsConsumed() {
        return unitsConsumed;
    }

    public void setUnitsConsumed(String unitsConsumed) {
        this.unitsConsumed = unitsConsumed;
    }

    @Override
    public String toString() {
        return "Hydro{" +
                "agencyName='" + agencyName + '\'' +
                ", unitsConsumed='" + unitsConsumed + '\'' +
                ", custId='" + custId + '\'' +
                ", id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", billType='" + billType + '\'' +
                ", billAmount='" + billAmount + '\'' +
                '}';
    }
}
