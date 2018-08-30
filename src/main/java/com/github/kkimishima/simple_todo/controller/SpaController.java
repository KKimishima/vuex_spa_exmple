package com.github.kkimishima.simple_todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/spa")
public class SpaController {
  @RequestMapping(method = RequestMethod.GET)
  public String index(){
    return "spa/index";
  }
}
