package com.lambton.c0777245_w2020_mad3125_fp.models;

public class Customer {
    private String id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private String mobile;

    public Customer() {
    }

    public Customer(String id, String firstName, String lastName, String email, String mobile) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.fullName = firstName + " " + lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

//    public String getFullName() {
//        return fullName;
//    }

//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                "customerId='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }

    public String fullName(){
        return  fullName;
    }
}
