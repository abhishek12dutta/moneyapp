package com.abhi.moneyapp.service;

import com.abhi.moneyapp.payload.Todo;

import java.util.List;

public interface TodoService {

    public void saveTodo(Todo todo, Long userId);

    public List<Todo> retrieveAllTodos(Long userId);

    Todo retrieveTodoById(Long id, Long todoId);

    void updateTodo(Todo todo, Long id, Long todoId);

    void toggleCompletedStatus(Long id, Long todoId);
}
