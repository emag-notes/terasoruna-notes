package com.example.helloworld.app.echo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("echo")
public class EchoController {

  @ModelAttribute
  public EchoForm setUpEchoForm() {
    return new EchoForm();
  }

  @RequestMapping
  public String index(Model model) {
    return "echo/index";
  }

  @RequestMapping(value = "hello", method = RequestMethod.POST)
  public String hello(@Validated EchoForm form, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "echo/index";
    }
    model.addAttribute("name", form.getName());
    return "echo/hello";
  }

}
