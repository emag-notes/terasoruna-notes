package com.example.todo.ws;

import com.example.todo.domain.model.Todo;
import com.example.todo.domain.service.TodoService;
import com.example.todo.ws.exception.WsExceptionHandler;
import com.example.todo.ws.webfault.WebFaultException;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

@Component
@WebService(
  portName = "TodoWebPort",
  serviceName = "TodoWebService",
  targetNamespace = "http://example.com/todo",
  endpointInterface = "com.example.todo.ws.TodoWebService")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class TodoWebServiceImpl implements TodoWebService {

  @Inject
  TodoService todoService;

  @Inject
  WsExceptionHandler exceptionHandler;

  @Override
  public Todo getTodo(String todoId) throws WebFaultException {
    try {
      return todoService.findOne(todoId);
    } catch (RuntimeException e) {
      throw exceptionHandler.translateException(e);
    }
  }

}
