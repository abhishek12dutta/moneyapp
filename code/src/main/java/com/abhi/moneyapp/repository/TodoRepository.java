package com.abhi.moneyapp.repository;

import com.abhi.moneyapp.repository.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {

    @Override
    Todo save(Todo todo);
}
