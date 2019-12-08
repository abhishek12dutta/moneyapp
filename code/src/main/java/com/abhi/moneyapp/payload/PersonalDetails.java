package com.abhi.moneyapp.payload;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PersonalDetails {

    @NotBlank
    @Size(min = 4, max = 40)
    private String addressline1;

    private String addressline2;

    @NotBlank
    @Size(min = 4, max = 40)
    private String country;

    @NotBlank
    @Size(min = 10, max = 10)
    private int pincode;

    @NotBlank
    @Size(min = 2, max = 6)
    private int phnextn;
    @NotBlank
    @Size(min = 10, max = 10)
    private Long phnno;

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

    public Long getPhnno() {
        return phnno;
    }

    public void setPhnno(Long phnno) {
        this.phnno = phnno;
    }

}
