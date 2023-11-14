package com.todolist.todolist.infrastructure.persistance.impl;

import com.todolist.todolist.core.entity.Todo;
import com.todolist.todolist.core.repository.TodoRepository;
import com.todolist.todolist.infrastructure.exception.ChangeStatusException;
import com.todolist.todolist.infrastructure.exception.TodoNotFoundException;
import com.todolist.todolist.infrastructure.persistance.repository.TodoRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TodoRepositoryImpl implements TodoRepository {

    private final TodoRepositoryJpa todoRepositoryJpa;

    public TodoRepositoryImpl(TodoRepositoryJpa todoRepositoryJpa) {
        this.todoRepositoryJpa = todoRepositoryJpa;
    }

    @Override
    public List<Todo> findAll() {
        return todoRepositoryJpa.findAll();
    }

    @Override
    public void createTodo(Todo todo) {
        todoRepositoryJpa.save(todo);
    }

    @Override
    public Optional<Todo> findById(String id) {
        return todoRepositoryJpa.findById(id);
    }

    @Override
    public void delete(String id) {
        Todo todo = todoRepositoryJpa.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("Cant find todo for deleting : " + id));
        todoRepositoryJpa.delete(todo);
    }

    @Override
    public void finish(String id) {
        var todo = findById(id).get();
        if (todo.getStatus().equals(Boolean.TRUE)) {
            throw new ChangeStatusException("Cant finish a finished job..");
        }
        todo.setStatus(true);
        todoRepositoryJpa.save(todo);
        //todoRepositoryJpa.updateStatusToTrueById(id);
    }
}
