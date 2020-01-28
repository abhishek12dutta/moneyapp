package com.abhi.moneyapp.mapper;

import com.abhi.moneyapp.payload.PersonalDetails;
import com.abhi.moneyapp.payload.SignUpRequest;
import com.abhi.moneyapp.payload.UserSummary;
import com.abhi.moneyapp.repository.model.Tag;
import com.abhi.moneyapp.repository.model.Todo;
import com.abhi.moneyapp.repository.model.User;
import com.abhi.moneyapp.repository.model.UserDetail;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GenericMapper {

    public UserSummary convertToAppUser(User user) {
        UserSummary userSummary = new UserSummary();
        userSummary.setFullNmae(user.getUserFullName());
        userSummary.setEmail(user.getEmail());
        userSummary.setUsername(user.getUsername());
        userSummary.setPhnNo(user.getUserDetail().getPhnextn() + user.getUserDetail().getPhnno());
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

    public Todo convertToDTO(com.abhi.moneyapp.payload.Todo todo) {
        Todo todoDTO = new Todo();
        todoDTO.setTitle(todo.getTitle());
        todoDTO.setCompletionStatus(todo.getCompletionStatus());
        todoDTO.setPriority(todo.getPriority());
        todoDTO.setDescription(todo.getDesc());
        todoDTO.setDate(todo.getDate());
//        for(String str: todo.getTags()){
//            todoDTO.getTags().add(new Tag(str));
//        }
        return todoDTO;
    }

    public com.abhi.moneyapp.payload.Todo convertToBO(Todo todo) {
        com.abhi.moneyapp.payload.Todo todoDTO = new com.abhi.moneyapp.payload.Todo();
        todoDTO.setId(Integer.parseInt(String.valueOf(todo.getId())));
        todoDTO.setTitle(todo.getTitle());
        todoDTO.setCompletionStatus(todo.getCompletionStatus());
        todoDTO.setPriority(todo.getPriority());
        todoDTO.setDesc(todo.getDescription());
        todoDTO.setDate(todo.getDate());
        List<String> tagList = new ArrayList<>();
        for(Tag tag: todo.getTags()){
            tagList.add(tag.getName());
        }
        todoDTO.setTags(tagList);
        return todoDTO;
    }
}
