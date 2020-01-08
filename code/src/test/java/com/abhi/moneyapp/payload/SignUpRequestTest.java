package com.abhi.moneyapp.payload;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

public class SignUpRequestTest {


    @Test
    public void createValidSignUpRequestJsonObject() throws JsonProcessingException {
        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setEmail("abhishek12dutta@gmail.com");
        signUpRequest.setName("Abhishek Dutta");
        signUpRequest.setPassword("password");
        signUpRequest.setUsername("abhipicku12");
        PersonalDetails personalDetails = new PersonalDetails();
        personalDetails.setCountry("India");
        personalDetails.setPincode("723133");
        personalDetails.setPhnextn("+91");
        personalDetails.setPhnno(new Long("9733892131"));
        signUpRequest.setPersonalDetails(personalDetails);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(signUpRequest);
        System.out.println(json);
    }

}
