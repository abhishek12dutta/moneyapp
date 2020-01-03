package com.abhi.moneyapp.service;

import com.abhi.moneyapp.payload.SignUpRequest;
import com.abhi.moneyapp.payload.UserSummary;

import java.util.List;

public interface UserService {

    public List<UserSummary> retrieveAllUsers();
    public boolean checkUserAvailability(String userName);
    public boolean checkEmailAvailability(String email);
    public void createUser(SignUpRequest signUpRequest);
    public UserSummary retrieveUser(Long id);



}
