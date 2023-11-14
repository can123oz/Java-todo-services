package com.todolist.todolist.core.usecase.impl;

import com.todolist.todolist.core.entity.Todo;
import com.todolist.todolist.core.repository.TodoRepository;
import com.todolist.todolist.core.usecase.GetAllTodosUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllTodosUseCaseImpl implements GetAllTodosUseCase {

    private final TodoRepository todoRepository;

    public GetAllTodosUseCaseImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> execute() {
        return todoRepository.findAll();
    }
}
