package todo.domain.service.todo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;
import todo.domain.model.Todo;
import todo.domain.repository.todo.TodoRepository;

import javax.inject.Inject;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {

  @Value("${todo.max_unfinished_count}")
  private long maxUnfinishedCount;

  @Inject
  TodoRepository todoRepository;

  @Transactional(readOnly = true)
  public Todo findOne(String todoId) {
    Todo todo = todoRepository.findOne(todoId);
    if (todo == null) {
      ResultMessages messages = ResultMessages.error();
      messages.add(ResultMessage.fromText(
        "[E404] The requested Todo is not found. (id="  + todoId + ")"));
      throw new ResourceNotFoundException(messages);
    }
    return todo;
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Todo> findAll() {
    return todoRepository.findAll();
  }

  @Override
  public Todo create(Todo todo) {
    long unfinishedCount = todoRepository.countByFinished(false);
    if (unfinishedCount >= maxUnfinishedCount) {
      ResultMessages messages = ResultMessages.error();
      messages.add(ResultMessage.fromText(
        "[E001] The count of un-finished Todo must not be over " + maxUnfinishedCount + "."));
      throw new BusinessException(messages);
    }

    String todoId = UUID.randomUUID().toString();
    Date date = new Date();

    todo.setTodoId(todoId);
    todo.setCreatedAt(date);
    todo.setFinished(false);

    todoRepository.create(todo);
    return todo;
  }

  @Override
  public Todo finish(String todoId) {
    Todo todo = findOne(todoId);
    if (todo.isFinished()) {
      ResultMessages messages = ResultMessages.error();
      messages.add(ResultMessage.fromText(
        "[E002] The requested Todo is already finished. (id=" + todoId + ")"));
      throw new BusinessException(messages);
    }

    todo.setFinished(true);
    todoRepository.update(todo);
    return todo;
  }

  @Override
  public void delete(String todoId) {
    Todo todo = findOne(todoId);
    todoRepository.delete(todo);
  }

}
