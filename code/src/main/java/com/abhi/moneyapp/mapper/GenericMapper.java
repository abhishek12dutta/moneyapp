package com.abhi.moneyapp.mapper;

import com.abhi.moneyapp.payload.AppUser;
import com.abhi.moneyapp.payload.PersonalDetails;
import com.abhi.moneyapp.payload.SignUpRequest;
import com.abhi.moneyapp.repository.model.User;
import com.abhi.moneyapp.repository.model.UserDetail;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class GenericMapper {

    public AppUser convertToAppUser(User user) {
        AppUser appUser = new AppUser();

        return appUser;
    }

    public User convertSignUpRequestToUser(SignUpRequest signUpRequest) {
        User user = new User();
        user.setUsername(signUpRequest.getUsername());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(signUpRequest.getPassword());
        user.setActive(false);
        user.setCreatedDate(new Date());
        if (null != signUpRequest.getPersonalDetails()) {
            UserDetail userDetail = new UserDetail();
            PersonalDetails personalDetails = signUpRequest.getPersonalDetails();
            userDetail.setAddressline1(personalDetails.getAddressline1());
            userDetail.setAddressline2(personalDetails.getAddressline2());
            userDetail.setCountry(personalDetails.getCountry());
            userDetail.setPincode(personalDetails.getPincode());
            userDetail.setPhnextn(personalDetails.getPhnextn());
            userDetail.setPhnno(personalDetails.getPhnno());
            user.setUserDetail(userDetail);
        }
        return user;
    }
}
