package com.abhi.moneyapp.payload;

import com.abhi.moneyapp.repository.model.Role;

import java.util.Set;

public class UserSummary {

    private Long id;
    private String username;
    private String email;
    private String fullNmae;
    private Set<Role> roleList;
    private String phnNo;
    private String pincode;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullNmae() {
        return fullNmae;
    }

    public void setFullNmae(String fullNmae) {
        this.fullNmae = fullNmae;
    }

    public Set<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(Set<Role> roleList) {
        this.roleList = roleList;
    }

    public String getPhnNo() {
        return phnNo;
    }

    public void setPhnNo(String phnNo) {
        this.phnNo = phnNo;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
