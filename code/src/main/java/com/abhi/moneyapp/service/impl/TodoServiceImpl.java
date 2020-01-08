package com.abhi.moneyapp.service.impl;

import com.abhi.moneyapp.mapper.GenericMapper;
import com.abhi.moneyapp.payload.Todo;
import com.abhi.moneyapp.repository.TodoRepository;
import com.abhi.moneyapp.repository.UserRepository;
import com.abhi.moneyapp.repository.model.User;
import com.abhi.moneyapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
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

    @Override
    public List<Todo> retrieveAllTodos(Long userId) {
        List<com.abhi.moneyapp.repository.model.Todo> todoList = todoRepository.findAllTodos(userId);
        List<Todo> todos = new ArrayList<>();
        for (com.abhi.moneyapp.repository.model.Todo todo : todoList) {
            todos.add(genericMapper.convertToBO(todo));
        }
        return todos;
    }

    @Override
    public Todo retrieveTodoById(Long id, Long todoId) {
        com.abhi.moneyapp.repository.model.Todo repoTodo = todoRepository.findTodoById(id, todoId);
        return genericMapper.convertToBO(repoTodo);
    }

    @Override
    public void updateTodo(Todo todo, Long id, Long todoId) {
        com.abhi.moneyapp.repository.model.Todo repoTodo = todoRepository.findTodoById(id, todoId);
        repoTodo.setPriority(todo.getPriority());
        repoTodo.setDescription(todo.getDesc());
        repoTodo.setDate(todo.getDate());
        repoTodo.setCompletionStatus(todo.isCompleted());
        todoRepository.save(repoTodo);
    }

    @Override
    public void toggleCompletedStatus(Long id, Long todoId) {
        com.abhi.moneyapp.repository.model.Todo repoTodo = todoRepository.findTodoById(id, todoId);
        repoTodo.setCompletionStatus(!repoTodo.isCompletionStatus());
        todoRepository.save(repoTodo);
    }
}
