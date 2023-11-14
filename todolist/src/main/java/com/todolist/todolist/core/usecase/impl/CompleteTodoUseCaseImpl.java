package com.todolist.todolist.core.usecase.impl;

import com.todolist.todolist.core.repository.TodoRepository;
import com.todolist.todolist.core.usecase.CompleteTodoUseCase;
import org.springframework.stereotype.Service;

@Service
public class CompleteTodoUseCaseImpl implements CompleteTodoUseCase {

    private final TodoRepository todoRepository;

    public CompleteTodoUseCaseImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void execute(String id) {
        todoRepository.finish(id);
    }
}
