package com.github.kkimishima.simple_todo.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "todo_progress")
public class TodoProgress {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "progress_name")
  private String progressName;

  @UpdateTimestamp
  @Column(name = "updated_time")
  private Timestamp updatedTime;

  @CreationTimestamp
  @Column(name = "created_time", updatable = false)
  public Timestamp createdTime;

}
