package com.github.kkimishima.simple_todo.service;

import com.github.kkimishima.simple_todo.domain.TodoList;
import com.github.kkimishima.simple_todo.domain.TodoProgress;
import com.github.kkimishima.simple_todo.domain.TodoSearch;
import com.github.kkimishima.simple_todo.domain.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TodoDemoService {
  public TodoList findById(Long id);
  public List<TodoProgress> progressFindAll();
  public void listDelete(TodoList todoList);
  public TodoList listSave(TodoList todoList);
  public Page<TodoList> findAll(Pageable pageable);
  public Page<TodoList> findByTitle(TodoSearch todoSearch, Pageable pageable);
//  public List<TodoList> findNameGroup();
}
