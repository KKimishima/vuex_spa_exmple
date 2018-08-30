package com.github.kkimishima.simple_todo.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "users")
public class Users {
  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name ="pass")
  private String pass;

  @CreationTimestamp
  @Column(name = "created_time", updatable = false)
  public Timestamp createdTime;

  @UpdateTimestamp
  @Column(name = "updated_time")
  private Timestamp updatedTime;
}
