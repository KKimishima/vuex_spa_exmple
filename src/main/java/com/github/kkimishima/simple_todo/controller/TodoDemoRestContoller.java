package com.github.kkimishima.simple_todo.controller;

import com.github.kkimishima.simple_todo.domain.LoginUserDetails;
import com.github.kkimishima.simple_todo.domain.TodoList;
import com.github.kkimishima.simple_todo.domain.TodoProgress;
import com.github.kkimishima.simple_todo.domain.TodoSearch;
import com.github.kkimishima.simple_todo.service.TodoDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/todolist")
public class TodoDemoRestContoller {
  private TodoDemoService todoDemoService;

  @Autowired
  public TodoDemoRestContoller(
      TodoDemoService todoDemoServiceImpl
  ) {
    this.todoDemoService = todoDemoServiceImpl;
  }

  @RequestMapping(method = RequestMethod.GET)
  public Page<TodoList> index(
      @ModelAttribute TodoSearch todoSearch,
      @PageableDefault(
          page = 0,
          size = 10,
          sort = {"id"},
          direction = Sort.Direction.ASC
      ) Pageable pageable
  ) {
    return todoDemoService.findByTitle(todoSearch, pageable);
  }

  @RequestMapping(value = "/userid")
  public Long userID(){
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    LoginUserDetails userID = (LoginUserDetails) principal;
    return userID.getId();
  }
  @RequestMapping(value = "/ProgressList", method = RequestMethod.GET)
  public List<TodoProgress> podoProgress() {
    return todoDemoService.progressFindAll();
  }

  @RequestMapping(value = "/new")
  public TodoList create(
      @Validated @ModelAttribute TodoList todoList
  ) {
    return todoDemoService.listSave(todoList);
  }
}
