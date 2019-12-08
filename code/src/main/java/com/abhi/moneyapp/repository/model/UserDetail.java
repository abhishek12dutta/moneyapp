package com.abhi.moneyapp.repository.model;

import javax.persistence.*;
@Entity
@Table(name = "app_user_details")
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_details_id;

    @Column(name = "user_address_line1", nullable = false)
    private String addressline1;

    @Column(name = "user_address_line2")
    private String addressline2;

    @Column(name = "user_country", nullable = false)
    private String country;

    @Column(name = "user_pincode")
    private int pincode;

    @Column(name = "user_phn_extension", nullable = false)
    private int phnextn;

    @Column(name = "user_phone_no", nullable = false)
    private long phnno;


    public int getUser_details_id() {
        return user_details_id;
    }

    public void setUser_details_id(int user_details_id) {
        this.user_details_id = user_details_id;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public int getPhnextn() {
        return phnextn;
    }

    public void setPhnextn(int phnextn) {
        this.phnextn = phnextn;
    }

    public long getPhnno() {
        return phnno;
    }

    public void setPhnno(long phnno) {
        this.phnno = phnno;
    }

}
