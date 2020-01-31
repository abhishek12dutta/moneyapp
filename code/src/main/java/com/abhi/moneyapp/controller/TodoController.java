package com.abhi.moneyapp.controller;

import com.abhi.moneyapp.payload.ApiResponse;
import com.abhi.moneyapp.payload.PurgeRequest;
import com.abhi.moneyapp.payload.Todo;
import com.abhi.moneyapp.security.CurrentUser;
import com.abhi.moneyapp.security.UserPrincipal;
import com.abhi.moneyapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
            todo = todoService.saveTodo(todo, currentUser.getId());
        } catch (DataAccessException d) {
            return new ResponseEntity(new ApiResponse(false, "ERROR"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(todo, HttpStatus.CREATED);
    }

    @GetMapping("/mytodos")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> fetchAllTodos(@CurrentUser UserPrincipal currentUser) {
        List<Todo> todos = new ArrayList<>();
        try {
            todos = todoService.retrieveAllTodos(currentUser.getId());
        } catch (DataAccessException d) {
            return new ResponseEntity(new ApiResponse(false, "ERROR"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(todos, HttpStatus.OK);
    }

    @GetMapping("/mytodo/{todoId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> fetchAllTodos(@CurrentUser UserPrincipal currentUser, @PathVariable("todoId") Long todoId) {
        Todo todo = null;
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            todo = todoService.retrieveTodoById(currentUser.getId(), todoId);
        } catch (DataAccessException d) {
            return new ResponseEntity(new ApiResponse(false, "ERROR"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(todo, HttpStatus.OK);
    }

    @PutMapping("/mytodo/update/{todoId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> updateTodo(@CurrentUser UserPrincipal currentUser, @PathVariable("todoId") Long todoId, @RequestBody Todo todo) {
        try {
            todoService.updateTodo(todo, currentUser.getId(), todoId);
        } catch (DataAccessException d) {
            return new ResponseEntity(new ApiResponse(false, "ERROR"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(new ApiResponse(true, "UPDATED"), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/mytodo/togglestatus")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> updateTodo(@CurrentUser UserPrincipal currentUser, @RequestParam(value = "todoId") Long todoId, @RequestParam(value = "completionStatus") String completionStatus) {
        try {
            todoService.toggleCompletedStatus(currentUser.getId(), todoId, completionStatus);
        } catch (DataAccessException d) {
            return new ResponseEntity(new ApiResponse(false, "ERROR"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(new ApiResponse(true, "UPDATED"), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/mytodo/delete/{todoId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> deleteTodo(@CurrentUser UserPrincipal currentUser, @PathVariable("todoId") Long todoId) {
        try {
            todoService.deleteTodo(currentUser.getId(), todoId);
        } catch (DataAccessException d) {
            return new ResponseEntity(new ApiResponse(false, "ERROR"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(new ApiResponse(true, "UPDATED"), HttpStatus.NO_CONTENT);
    }


    @PostMapping("/mytodo/archive")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> archiveTodo(@CurrentUser UserPrincipal currentUser, @RequestBody PurgeRequest purgeRequest) {
        Todo todo = null;
        try {
            todo = todoService.archiveTodo(purgeRequest, currentUser.getId());
        } catch (DataAccessException d) {
            return new ResponseEntity(new ApiResponse(false, "ERROR"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(todo, HttpStatus.CREATED);
    }

}
