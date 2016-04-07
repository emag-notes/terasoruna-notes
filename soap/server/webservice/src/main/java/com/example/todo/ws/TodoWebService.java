package com.example.todo.ws;

import com.example.todo.domain.model.Todo;
import com.example.todo.ws.webfault.WebFaultException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://example.com/todo")
public interface TodoWebService {

  @WebMethod
  @WebResult(name = "todo")
  Todo getTodo(@WebParam(name = "todoId") String todoId) throws WebFaultException;

}
