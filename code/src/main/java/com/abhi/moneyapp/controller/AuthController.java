package com.abhi.moneyapp.controller;

import com.abhi.moneyapp.payload.ApiResponse;
import com.abhi.moneyapp.payload.SignUpRequest;
import com.abhi.moneyapp.repository.model.Role;
import com.abhi.moneyapp.repository.model.RoleName;
import com.abhi.moneyapp.repository.model.User;
import com.abhi.moneyapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

        if(userService.checkUserAvailability(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userService.checkEmailAvailability(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }


        userService.createUser(signUpRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(signUpRequest.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }

//    @PostMapping("/signin")
//    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginRequest.getUsernameOrEmail(),
//                        loginRequest.getPassword()
//                )
//        );
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        String jwt = tokenProvider.generateToken(authentication);
//        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
//    }
}
