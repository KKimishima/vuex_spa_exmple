package com.github.kkimishima.simple_todo.repository;

import com.github.kkimishima.simple_todo.domain.TodoProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoProgressRepository extends JpaRepository<TodoProgress,Long> {
//  @Query("SELECT t.id,t.progressName FROM TodoProgress t GROUP BY t.id,t.progressName ORDER BY t.id")
//  public List<TodoProgress> findNameGroup();
  public List<TodoProgress> findAll();
}
