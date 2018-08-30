package com.github.kkimishima.simple_todo.repository;

import com.github.kkimishima.simple_todo.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
  public Users findByName(String name);
}
