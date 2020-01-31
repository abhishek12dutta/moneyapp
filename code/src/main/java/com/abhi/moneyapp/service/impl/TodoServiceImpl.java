package com.abhi.moneyapp.service.impl;

import com.abhi.moneyapp.mapper.GenericMapper;
import com.abhi.moneyapp.payload.PurgeRequest;
import com.abhi.moneyapp.payload.Todo;
import com.abhi.moneyapp.repository.TagRepository;
import com.abhi.moneyapp.repository.TodoRepository;
import com.abhi.moneyapp.repository.UserRepository;
import com.abhi.moneyapp.repository.model.Tag;
import com.abhi.moneyapp.repository.model.User;
import com.abhi.moneyapp.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TodoServiceImpl implements TodoService {

    private static final Logger log = LoggerFactory.getLogger(TodoServiceImpl.class);

    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GenericMapper genericMapper;
    @Autowired
    private TagRepository tagRepository;

    @Override
    public Todo saveTodo(Todo todo, Long userId) {
        Optional<User> user = userRepository.findById(userId);
        User user1 = user.get();
        com.abhi.moneyapp.repository.model.Todo t = genericMapper.convertToDTO(todo);
        for (String str : todo.getTags()) {
            Tag tag = tagRepository.findTagByName(str);
            t.getTags().add(tag);
        }
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
        log.info("Entering retrieveTodoById() .......");
        com.abhi.moneyapp.repository.model.Todo repoTodo = todoRepository.findTodoById(id, todoId);

        log.info("The tags attached with todo id {} : {}", todoId, repoTodo.getTags().size());

        log.info("Exiting retrieveTodoById() .......");
        return genericMapper.convertToBO(repoTodo);
    }

    @Override
    public Todo updateTodo(Todo todo, Long id, Long todoId) {
        com.abhi.moneyapp.repository.model.Todo repoTodo = todoRepository.findTodoById(id, todoId);
        repoTodo.setTitle(todo.getTitle());
        repoTodo.setPriority(todo.getPriority());
        repoTodo.setDescription(todo.getDesc());
        repoTodo.setDate(todo.getDate());
        repoTodo.setCompletionStatus(todo.getCompletionStatus());
        Set<Tag> tagList = new HashSet<>();
        for (String str : todo.getTags()) {
            Tag tag = tagRepository.findTagByName(str);
            tagList.add(tag);
        }
        repoTodo.setTags(tagList);
        return genericMapper.convertToBO(todoRepository.save(repoTodo));
    }

    @Override
    public void toggleCompletedStatus(Long id, Long todoId, String status) {
        com.abhi.moneyapp.repository.model.Todo repoTodo = todoRepository.findTodoById(id, todoId);
        repoTodo.setCompletionStatus(status);
        todoRepository.save(repoTodo);
    }

    @Override
    public void deleteTodo(Long id, Long todoId) {
        com.abhi.moneyapp.repository.model.Todo repoTodo = todoRepository.findTodoById(id, todoId);

//        for(Tag tag : repoTodo.getTags()){
//            repoTodo.removeTag(tag);
//        }

        if (repoTodo != null) {
            todoRepository.deleteById(todoId);
        }
    }

    @Override
    public Todo archiveTodo(PurgeRequest purgeRequest, Long id) {

        com.abhi.moneyapp.repository.model.Todo repoTodo = todoRepository.findTodoById(id,
                Long.parseLong(String.valueOf(purgeRequest.getId())));

        if (repoTodo != null) {
            repoTodo.setPurged(purgeRequest.getAction().equalsIgnoreCase("P"));
            repoTodo = todoRepository.save(repoTodo);
        }

        return genericMapper.convertToBO(todoRepository.save(repoTodo));
    }
}
