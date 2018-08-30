package com.github.kkimishima.simple_todo.repository;

import com.github.kkimishima.simple_todo.domain.TodoList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList,Long>, CrudRepository<TodoList,Long> ,JpaSpecificationExecutor<TodoList> {
  public List<TodoList> findAll();
  public Page<TodoList> findAll(Pageable pageable);
  public Page<TodoList> findAll(Specification specification, Pageable pageable);
}
