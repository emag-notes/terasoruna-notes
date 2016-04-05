package todo.domain.service.todo;

import todo.domain.model.Todo;

import java.util.Collection;

public interface TodoService {

  Collection<Todo> findAll();
  Todo create(Todo todo);
  Todo finish(String todoId);
  void delete(String todoId);

}
