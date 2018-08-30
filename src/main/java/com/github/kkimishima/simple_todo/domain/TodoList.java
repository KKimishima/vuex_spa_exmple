package com.github.kkimishima.simple_todo.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "todo_list")
public class TodoList {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @NotEmpty(message = "タイトルを入力してください!!!")
  @Column(name = "title")
  private String title;

  @Column(name = "describe")
  private String describe;

  @UpdateTimestamp
  @Column(name = "updated_time")
  private Timestamp updatedTime;

  @CreationTimestamp
  @Column(name = "created_time", updatable = false)
  private Timestamp createdTime;

  @ManyToOne
  @JoinColumn(name = "progress_id")
  private TodoProgress todoProgress;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private Users users;

  @NotNull(message = "日時を指定してください!!!")
  @Column(name = "limit_date")
  private Date limitDate;


  @Column(name = "limit_time")
  private Time limitTime;
}
