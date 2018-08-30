package com.github.kkimishima.simple_todo.service;

import com.github.kkimishima.simple_todo.component.TodoListSpecification;
import com.github.kkimishima.simple_todo.domain.TodoList;
import com.github.kkimishima.simple_todo.domain.TodoProgress;
import com.github.kkimishima.simple_todo.domain.TodoSearch;
import com.github.kkimishima.simple_todo.repository.TodoListRepository;
import com.github.kkimishima.simple_todo.repository.TodoProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoDemoServiceImpl implements TodoDemoService {
  private TodoListRepository todoListRepository;
  private TodoProgressRepository todoProgressRepository;
  private TodoListSpecification todoListSpecification;

  @Autowired
  public TodoDemoServiceImpl(
      TodoListRepository todoListRepository,
      TodoProgressRepository todoProgressRepository,
      TodoListSpecification todoListSpecification
  ) {
    this.todoListRepository = todoListRepository;
    this.todoProgressRepository = todoProgressRepository;
    this.todoListSpecification = todoListSpecification;
  }


  @Override
  public TodoList findById(Long id) {
    return todoListRepository.getOne(id);
  }

  @Override
  public List<TodoProgress> progressFindAll() {
    return todoProgressRepository.findAll();
  }

  @Override
  public void listDelete(TodoList todoList) {
    todoListRepository.delete(todoList);
  }

  @Override
  public TodoList listSave(TodoList todoList) {
    return todoListRepository.save(todoList);
  }

  @Override
  public Page<TodoList> findAll(Pageable pageable) {
    return todoListRepository.findAll(pageable);
  }

  @Override
  public Page<TodoList> findByTitle(TodoSearch todoSearch, Pageable pageable) {
    return todoListRepository.findAll(Specifications
        .where(todoListSpecification
            .findTitle(todoSearch.getTitle()))
        .and(todoListSpecification
            .findDescribre(todoSearch.getDescribe()))
        .and(todoListSpecification
            .findLimitDate(todoSearch.getMinDate(), todoSearch.getMaxDate()))
        .and(todoListSpecification
            .findProgres(todoSearch.getProgressId())
        ), pageable);
  }
}
