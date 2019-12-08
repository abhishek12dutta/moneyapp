package com.abhi.moneyapp.service;

import com.abhi.moneyapp.payload.AppUser;
import com.abhi.moneyapp.payload.SignUpRequest;

import java.util.List;

public interface UserService {

    public List<AppUser> retrieveAllUsers();
    public boolean checkUserAvailability(String userName);
    public boolean checkEmailAvailability(String email);

    public void createUser(SignUpRequest signUpRequest);



}
