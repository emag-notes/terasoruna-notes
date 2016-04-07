package com.example.todo.ws.webfault;

import javax.xml.ws.WebFault;
import java.util.List;

@WebFault(name = "WebFault", targetNamespace = "http://example.com/todo")
public class WebFaultException extends Exception {

  private WebFaultBean faultInfo;

  public WebFaultException() {}

  public WebFaultException(String message, WebFaultBean faultInfo) {
    super(message);
    this.faultInfo = faultInfo;
  }

  public WebFaultException(String message, WebFaultBean faultInfo, Throwable e) {
    super(message, e);
    this.faultInfo = faultInfo;
  }

  public List<ErrorBean> getErrors() {
    return this.faultInfo.getErrors();
  }

  public WebFaultType getType() {
    return this.faultInfo.getType();
  }

  public WebFaultBean getFaultInfo() {
    return faultInfo;
  }

  public void setFaultInfo(WebFaultBean faultInfo) {
    this.faultInfo = faultInfo;
  }

}
