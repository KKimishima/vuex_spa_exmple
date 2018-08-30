package com.github.kkimishima.simple_todo.component;

import com.github.kkimishima.simple_todo.domain.TodoList;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TodoListSpecification {
  public Specification<TodoList> findTitle(String title) {
    return title == null || title.isEmpty() ? null :
        (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
            root.<String>get("title"), "%" + title + "%");
  }

  public Specification<TodoList> findDescribre(String describe) {
    return describe == null || describe.isEmpty() ? null :
        (root, criteriaQuery, criteriaBuilder) ->
            criteriaBuilder.like(
                root.<String>get("describe"), "%" + describe + "%"
            );
  }
  public Specification<TodoList> findProgres(Long progress_id){
    return progress_id == null ? null :
        ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(
            root.<Long>get("todoProgress"),progress_id)
        );
  }
  public Specification<TodoList> findLimitDate(Date minDate, Date maxDate) {
    String check = null;
    if (minDate != null && maxDate  != null){
      check = "ok";
    }
    return check == null ? null :
        ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.between(
            root.<Date>get("limitDate"), minDate, maxDate)
        );
  }
}
