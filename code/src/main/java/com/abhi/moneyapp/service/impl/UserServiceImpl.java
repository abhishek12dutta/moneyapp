package com.abhi.moneyapp.service.impl;

import com.abhi.moneyapp.controller.RoleRepository;
import com.abhi.moneyapp.exception.AppException;
import com.abhi.moneyapp.mapper.GenericMapper;
import com.abhi.moneyapp.payload.SignUpRequest;
import com.abhi.moneyapp.payload.UserSummary;
import com.abhi.moneyapp.repository.UserRepository;
import com.abhi.moneyapp.repository.model.Role;
import com.abhi.moneyapp.repository.model.RoleName;
import com.abhi.moneyapp.repository.model.User;
import com.abhi.moneyapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private GenericMapper genericMapper;

    @Override
    public List<UserSummary> retrieveAllUsers() {
        List<UserSummary> appUserList = new ArrayList<>();
        List<User> userList = userRepository.findAll();

        for (User user : userList) {
            appUserList.add(genericMapper.convertToAppUser(user));
        }
        return appUserList;
    }

    @Override
    public boolean checkUserAvailability(String userName) {

        return !userRepository.existsByUsername(userName);
    }

    @Override
    public boolean checkEmailAvailability(String email) {
        return !userRepository.existsByEmail(email);
    }

    @Override
    public void createUser(SignUpRequest signUpRequest) throws AppException {
        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new AppException("User Role not set."));
        signUpRequest.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        User user = genericMapper.convertSignUpRequestToUser(signUpRequest);
        //set role to user
        user.setRoles(Collections.singleton(userRole));
        User result = userRepository.save(user);

    }

    @Override
    public UserSummary retrieveUser(Long id) {
        User user = userRepository.getOne(id);
        UserSummary userSummary = genericMapper.convertToAppUser(user);
        return userSummary;
    }
}
