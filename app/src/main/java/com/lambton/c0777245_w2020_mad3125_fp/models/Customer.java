package com.lambton.c0777245_w2020_mad3125_fp.models;

public class Customer {
    private String  customerId;
    private String firstName;
    private String lastName;
    private String fullName;
    private String emailId;
    private String mobile;

    public Customer() {
    }

    public Customer(String customerId, String firstName, String lastName, String fullName, String emailId, String mobile) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.emailId = emailId;
        this.mobile = mobile;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
