package com.abhi.moneyapp.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PersonalDetails {

    @NotBlank
    @Size(min = 4, max = 40)
    private String country;

    @NotBlank
    @Size(min = 10, max = 10)
    private String pincode;

    @NotBlank
    @Size(min = 2, max = 6)
    private String phnextn;
    @NotBlank
    @Size(min = 10, max = 10)
    private Long phnno;

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

    public Long getPhnno() {
        return phnno;
    }

    public void setPhnno(Long phnno) {
        this.phnno = phnno;
    }
}
