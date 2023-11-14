package com.todolist.todolist.core.usecase.impl;

import com.todolist.todolist.core.repository.TodoRepository;
import com.todolist.todolist.core.usecase.DeleteTodoUseCase;
import org.springframework.stereotype.Service;

@Service
public class DeleteTodoUseCaseImpl implements DeleteTodoUseCase {

    private final TodoRepository todoRepository;

    public DeleteTodoUseCaseImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void execute(String id) {
        todoRepository.delete(id);
    }
}
