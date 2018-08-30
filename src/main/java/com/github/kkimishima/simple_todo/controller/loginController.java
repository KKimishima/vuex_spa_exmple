package com.github.kkimishima.simple_todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class loginController {
  @RequestMapping(method = RequestMethod.GET,value = "/loginForm")
  public String loginForm(){
    return "login/loginForm";
  }
}
