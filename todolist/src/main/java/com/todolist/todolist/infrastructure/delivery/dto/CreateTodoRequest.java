package com.todolist.todolist.infrastructure.delivery.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTodoRequest {

    @NotNull
    @Size(max = 20, min = 2, message = "Todo description has to be 2 to 20 characters")
    private String description;
}
