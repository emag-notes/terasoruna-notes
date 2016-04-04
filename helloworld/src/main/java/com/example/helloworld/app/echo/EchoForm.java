package com.example.helloworld.app.echo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class EchoForm implements Serializable {

  @NotNull
  @Size(min = 1, max = 5)
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
