package com.abhi.moneyapp.service.impl;

import com.abhi.moneyapp.mapper.GenericMapper;
import com.abhi.moneyapp.payload.Todo;
import com.abhi.moneyapp.repository.TodoRepository;
import com.abhi.moneyapp.repository.UserRepository;
import com.abhi.moneyapp.repository.model.User;
import com.abhi.moneyapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoRepository todoRepository;
    private UserRepository userRepository;
    @Autowired
    private GenericMapper genericMapper;

    @Override
    public void saveTodo(Todo todo, Long userId) {
        Optional<User> user = userRepository.findById(userId);
        User user1 = user.get();
        com.abhi.moneyapp.repository.model.Todo t = genericMapper.convertToDTO(todo);
        t.setUser(user1);
        todoRepository.save(t);
    }
}
