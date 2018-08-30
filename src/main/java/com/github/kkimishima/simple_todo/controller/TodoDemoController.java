package com.github.kkimishima.simple_todo.controller;

import com.github.kkimishima.simple_todo.domain.LoginUserDetails;
import com.github.kkimishima.simple_todo.domain.TodoList;
import com.github.kkimishima.simple_todo.domain.TodoSearch;
import com.github.kkimishima.simple_todo.service.TodoDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = {"/demo","/"})
public class TodoDemoController {
  private TodoDemoService todoDemoService;

  @Autowired
  public TodoDemoController(
      TodoDemoService todoDemoService
  ) {
    this.todoDemoService = todoDemoService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String index(
      Model model,
      @PageableDefault(
          page = 0,
          size = 10,
          sort = {"id"},
          direction = Sort.Direction.ASC
      ) Pageable pageable
  ) {
    model.addAttribute("todoSearch",new TodoSearch());
    model.addAttribute("progress", todoDemoService.progressFindAll());
    model.addAttribute("page", todoDemoService.findAll(pageable));
    model.addAttribute("url", "/demo");
    return "tododemo/index";
  }

  @RequestMapping(method = RequestMethod.GET, value = "/show/{id}")
  public String show(Model model, @PathVariable Long id) {
    model.addAttribute("item", todoDemoService.findById(id));
    return "tododemo/show";
  }


  @RequestMapping(method = RequestMethod.GET, value = "/new")
  public String news(Model model) {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    LoginUserDetails userID = (LoginUserDetails) principal;
    model.addAttribute("progress", todoDemoService.progressFindAll());
    model.addAttribute("userId", userID.getId());
    model.addAttribute("todoList", new TodoList());
    model.addAttribute("method", "POST");
    model.addAttribute("action", "/demo");
    return "tododemo/new";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String create(@ModelAttribute @Validated TodoList todoList, BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      LoginUserDetails userID = (LoginUserDetails) principal;
      model.addAttribute("progress", todoDemoService.progressFindAll());
      model.addAttribute("userId", userID.getId());
      model.addAttribute("method", "POST");
      model.addAttribute("action", "/demo");
      return "tododemo/new";
    }
    TodoList result = todoDemoService.listSave(todoList);
    model.addAttribute("item", result);
    return "tododemo/show";
  }

  @RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
  public String edit(Model model, @PathVariable Long id) {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    LoginUserDetails userID = (LoginUserDetails) principal;
    model.addAttribute("userId", userID.getId());
    model.addAttribute("todoList", todoDemoService.findById(id));
    model.addAttribute("progress", todoDemoService.progressFindAll());
    model.addAttribute("method", "PATCH");
    model.addAttribute("action", "/demo");
    return "tododemo/edit";
  }


  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public String delete(Model model, @PathVariable Long id) {
    TodoList todoList = todoDemoService.findById(id);
    todoDemoService.listDelete(todoList);
    return "redirect:/demo";
  }

  @RequestMapping(method = RequestMethod.PATCH)
  public String update(@ModelAttribute @Validated TodoList todoList, BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      LoginUserDetails userID = (LoginUserDetails) principal;
      model.addAttribute("progress", todoDemoService.progressFindAll());
      model.addAttribute("userId", userID.getId());
      model.addAttribute("method", "POST");
      model.addAttribute("action", "/demo");
      return "tododemo/edit";
    }
    TodoList result = todoDemoService.listSave(todoList);
    model.addAttribute("item", result);
    return "tododemo/show";
  }
}
