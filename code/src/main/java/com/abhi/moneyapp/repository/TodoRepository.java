package com.abhi.moneyapp.repository;

import com.abhi.moneyapp.repository.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo,Long> {

    @Override
    Todo save(Todo todo);

    @Query(value = "SELECT u FROM todo u WHERE u.user.userId = ?1")
    List<Todo> findAllTodos(Long userId);

    @Query(value = "SELECT u FROM todo u WHERE u.user.userId = ?1 and u.id = ?2")
    Todo findTodoById(Long id, Long todoId);

}
