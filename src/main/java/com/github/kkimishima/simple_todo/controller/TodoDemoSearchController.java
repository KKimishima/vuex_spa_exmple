package com.github.kkimishima.simple_todo.controller;

import com.github.kkimishima.simple_todo.domain.TodoList;
import com.github.kkimishima.simple_todo.domain.TodoSearch;
import com.github.kkimishima.simple_todo.service.TodoDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping(value = "/demo/search")
public class TodoDemoSearchController {
  private TodoDemoService todoDemoService;

  @Autowired
  public TodoDemoSearchController(
      TodoDemoService todoDemoService
  ) {
    this.todoDemoService = todoDemoService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String index(
      @ModelAttribute TodoSearch todoSearch,
      Model model,
      BindingResult bindingResult,
      @PageableDefault(
          page = 0,
          size = 10,
          sort = {"id"},
          direction = Sort.Direction.ASC
      ) Pageable pageable
  ) {
    model.addAttribute("progress", todoDemoService.progressFindAll());
    model.addAttribute("page", todoDemoService.findByTitle(todoSearch, pageable));
    model.addAttribute("url", "/demo/search?" + todoSearch.toString());
    return "tododemo/index";
  }

}
