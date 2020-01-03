package com.abhi.moneyapp.controller;

import com.abhi.moneyapp.payload.UserSummary;
import com.abhi.moneyapp.security.CurrentUser;
import com.abhi.moneyapp.security.UserPrincipal;
import com.abhi.moneyapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public List<UserSummary> getAllUsers() {
        return userService.retrieveAllUsers();
    }

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {

        UserSummary userSummary = userService.retrieveUser(currentUser.getId());
        return userSummary;
    }

    @GetMapping("/user/checkUsernameAvailability")
    public boolean checkUsernameAvailability(@RequestParam String username) {
        return userService.checkUserAvailability(username);
    }

    @GetMapping("/user/checkEmailAvailability")
    public boolean checkEmailAvailability(@RequestParam String email) {
        return userService.checkEmailAvailability(email);
    }

}
