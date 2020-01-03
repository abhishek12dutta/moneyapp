package com.abhi.moneyapp.mapper;

import com.abhi.moneyapp.payload.PersonalDetails;
import com.abhi.moneyapp.payload.SignUpRequest;
import com.abhi.moneyapp.payload.UserSummary;
import com.abhi.moneyapp.repository.model.User;
import com.abhi.moneyapp.repository.model.UserDetail;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class GenericMapper {

    public UserSummary convertToAppUser(User user) {
        UserSummary userSummary = new UserSummary();
        userSummary.setFullNmae(user.getUserFullName());
        userSummary.setEmail(user.getEmail());
        userSummary.setUsername(user.getUsername());
        userSummary.setPhnNo(String.valueOf(user.getUserDetail().getPhnextn()) + String.valueOf(user.getUserDetail().getPhnno()));
        userSummary.setPincode(String.valueOf(user.getUserDetail().getPincode()));
        userSummary.setId(user.getUserId());
        userSummary.setRoleList(user.getRoles());
        return userSummary;
    }

    public User convertSignUpRequestToUser(SignUpRequest signUpRequest) {
        User user = new User();
        user.setUserFullName(signUpRequest.getName());
        user.setUsername(signUpRequest.getUsername());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(signUpRequest.getPassword());
        user.setActive(false);
        user.setCreatedDate(new Date());
        if (null != signUpRequest.getPersonalDetails()) {
            UserDetail userDetail = new UserDetail();
            PersonalDetails personalDetails = signUpRequest.getPersonalDetails();
            userDetail.setPincode(personalDetails.getPincode());
            userDetail.setPhnextn(personalDetails.getPhnextn());
            userDetail.setPhnno(personalDetails.getPhnno());
            user.setUserDetail(userDetail);
        }
        return user;
    }
}
