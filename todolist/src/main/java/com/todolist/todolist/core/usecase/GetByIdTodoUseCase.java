package com.todolist.todolist.core.usecase;

import com.todolist.todolist.core.entity.Todo;
import java.util.Optional;

public interface GetByIdTodoUseCase {
    Optional<Todo> execute(String id);
}
