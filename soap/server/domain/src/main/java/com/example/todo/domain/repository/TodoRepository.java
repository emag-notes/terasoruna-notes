package com.example.todo.domain.repository;

import com.example.todo.domain.model.Todo;

import java.util.Collection;

public interface TodoRepository {

  Todo findOne(String todoId);
  Collection<Todo> findAll();
  void create(Todo todo);
  boolean update(Todo todo);
  void delete(Todo todo);
  long countByFinished(boolean finished);

}
