package com.todolist.todolist.core.usecase.impl;

import com.todolist.todolist.core.entity.Todo;
import com.todolist.todolist.core.repository.TodoRepository;
import com.todolist.todolist.core.usecase.GetByIdTodoUseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetByIdTodoUseCaseImpl implements GetByIdTodoUseCase {

    private final TodoRepository todoRepository;

    public GetByIdTodoUseCaseImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Optional<Todo> execute(String id) {
        return todoRepository.findById(id);
    }
}
