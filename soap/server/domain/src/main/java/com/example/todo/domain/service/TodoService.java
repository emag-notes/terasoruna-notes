package com.example.todo.domain.service;

import com.example.todo.domain.model.Todo;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;

@Validated
public interface TodoService {

  Todo findOne(String todoId);
  Collection<Todo> findAll();
  Todo create(Todo todo);
  Todo finish(String todoId);
  void delete(String todoId);

}
