package com.example.todo.domain.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.Date;

public class Todo implements Serializable {

  public interface Create {}
  public interface Update {}

  @Null(groups = Create.class)
  @NotNull(groups = Update.class)
  private String todoId;

  @NotNull
  private String todoTitle;

  private boolean finished;

  @NotNull
  private Date createdAt;

  public String getTodoId() {
    return todoId;
  }

  public void setTodoId(String todoId) {
    this.todoId = todoId;
  }

  public String getTodoTitle() {
    return todoTitle;
  }

  public void setTodoTitle(String todoTitle) {
    this.todoTitle = todoTitle;
  }

  public boolean isFinished() {
    return finished;
  }

  public void setFinished(boolean finished) {
    this.finished = finished;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

}
