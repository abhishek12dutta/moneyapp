package com.abhi.moneyapp.repository.model;

import javax.persistence.*;
@Entity
@Table(name = "app_user_details")
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_details_id;


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
