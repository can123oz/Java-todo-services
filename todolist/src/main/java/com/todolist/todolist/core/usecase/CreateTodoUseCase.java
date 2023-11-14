package com.todolist.todolist.core.usecase;

import com.todolist.todolist.core.entity.Todo;

public interface CreateTodoUseCase {
    void execute(Todo todo);
}
