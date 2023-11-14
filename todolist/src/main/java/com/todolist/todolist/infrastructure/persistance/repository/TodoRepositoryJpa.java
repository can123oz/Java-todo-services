package com.todolist.todolist.infrastructure.persistance.repository;

import com.todolist.todolist.core.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface TodoRepositoryJpa extends JpaRepository<Todo, String> {

}
