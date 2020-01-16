package com.abhi.moneyapp.service.impl;

import com.abhi.moneyapp.mapper.GenericMapper;
import com.abhi.moneyapp.payload.Todo;
import com.abhi.moneyapp.repository.TodoRepository;
import com.abhi.moneyapp.repository.UserRepository;
import com.abhi.moneyapp.repository.model.Tag;
import com.abhi.moneyapp.repository.model.User;
import com.abhi.moneyapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GenericMapper genericMapper;

    @Override
    public Todo saveTodo(Todo todo, Long userId) {
        Optional<User> user = userRepository.findById(userId);
        User user1 = user.get();
        com.abhi.moneyapp.repository.model.Todo t = genericMapper.convertToDTO(todo);
        t.setUser(user1);
        t = todoRepository.save(t);
        return genericMapper.convertToBO(t);
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
    public Todo updateTodo(Todo todo, Long id, Long todoId) {
        com.abhi.moneyapp.repository.model.Todo repoTodo = todoRepository.findTodoById(id, todoId);
        repoTodo.setTags(null);
        todoRepository.save(repoTodo);
        repoTodo.setTitle(todo.getTitle());
        repoTodo.setPriority(todo.getPriority());
        repoTodo.setDescription(todo.getDesc());
        repoTodo.setDate(todo.getDate());
        repoTodo.setCompletionStatus(todo.isCompleted());
        Set<Tag> tagList = new HashSet<>();
        for(String str: todo.getTags()){
            tagList.add(new Tag(str));
        }
        repoTodo.setTags(tagList);
        return genericMapper.convertToBO(todoRepository.save(repoTodo));
    }

    @Override
    public void toggleCompletedStatus(Long id, Long todoId) {
        com.abhi.moneyapp.repository.model.Todo repoTodo = todoRepository.findTodoById(id, todoId);
        repoTodo.setCompletionStatus(!repoTodo.isCompletionStatus());
        todoRepository.save(repoTodo);
    }

    @Override
    public void deleteTodo(Long id, Long todoId) {
        com.abhi.moneyapp.repository.model.Todo repoTodo = todoRepository.findTodoById(id, todoId);
        if (repoTodo != null) {
            todoRepository.deleteById(todoId);
        }
    }
}
