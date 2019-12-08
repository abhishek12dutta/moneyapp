package com.abhi.moneyapp.controller;

import com.abhi.moneyapp.payload.AppUser;
import com.abhi.moneyapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public List<AppUser> getAllUsers() {
        return userService.retrieveAllUsers();
    }

}
