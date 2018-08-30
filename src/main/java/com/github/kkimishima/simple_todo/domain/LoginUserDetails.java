package com.github.kkimishima.simple_todo.domain;

import com.github.kkimishima.simple_todo.domain.Users;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class LoginUserDetails extends User {
  private Users users;
  private Long id;

  public LoginUserDetails(Users users) {
    super(users.getName(), users.getPass(), AuthorityUtils.createAuthorityList("ROLE_USER"));
    this.id = users.getId();
    this.users = users;
  }

}
