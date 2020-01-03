package com.abhi.moneyapp.controller;

import com.abhi.moneyapp.payload.ApiResponse;
import com.abhi.moneyapp.payload.Todo;
import com.abhi.moneyapp.payload.UserSummary;
import com.abhi.moneyapp.security.CurrentUser;
import com.abhi.moneyapp.security.UserPrincipal;
import com.abhi.moneyapp.service.TodoService;
import com.abhi.moneyapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> saveTodo(@CurrentUser UserPrincipal currentUser, @RequestBody Todo todo) {
        try {
            todoService.saveTodo(todo, currentUser.getId());
        } catch (DataAccessException d) {
            return new ResponseEntity(new ApiResponse(false, "ERROR"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(new ApiResponse(true, "CREATED"), HttpStatus.CREATED);
    }

}
