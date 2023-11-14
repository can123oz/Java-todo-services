package com.todolist.todolist.core.usecase.impl;

import com.todolist.todolist.core.entity.Todo;
import com.todolist.todolist.core.repository.TodoRepository;
import com.todolist.todolist.core.usecase.CreateTodoUseCase;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateTodoUseCaseImpl implements CreateTodoUseCase {

    private final TodoRepository todoRepository;

    public CreateTodoUseCaseImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void execute(Todo todo) {
        todo.setStatus(false);
        todo.setCreationDate(LocalDateTime.now());
        todoRepository.createTodo(todo);
    }
}
