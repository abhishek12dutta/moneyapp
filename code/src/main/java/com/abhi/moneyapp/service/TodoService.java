package com.abhi.moneyapp.service;

import com.abhi.moneyapp.payload.Todo;
import com.abhi.moneyapp.repository.model.User;
import org.springframework.stereotype.Service;

@Service
public interface TodoService {

    public void saveTodo(Todo todo, Long userId);
}
