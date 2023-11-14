package com.todolist.todolist.core.repository;

import com.todolist.todolist.core.entity.Todo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

public interface TodoRepository {
    List<Todo> findAll();
    void createTodo(Todo todo);
    Optional<Todo> findById(String id);
    void delete(String id);
    void finish(String id);
}
