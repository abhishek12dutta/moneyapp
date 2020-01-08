package com.abhi.moneyapp.repository.model;

import javax.persistence.*;
@Entity
@Table(name = "app_user_details")
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_details_id;


    @Column(name = "user_country_code")
    private String country;

    @Column(name = "user_pincode")
    private String pincode;

    @Column(name = "user_phn_extension", nullable = false)
    private String phnextn;

    @Column(name = "user_phone_no", nullable = false)
    private long phnno;

    public int getUser_details_id() {
        return user_details_id;
    }

    public void setUser_details_id(int user_details_id) {
        this.user_details_id = user_details_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPhnextn() {
        return phnextn;
    }

    public void setPhnextn(String phnextn) {
        this.phnextn = phnextn;
    }

    public long getPhnno() {
        return phnno;
    }

    public void setPhnno(long phnno) {
        this.phnno = phnno;
    }
}
