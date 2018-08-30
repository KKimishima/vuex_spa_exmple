package com.github.kkimishima.simple_todo.service;

import com.github.kkimishima.simple_todo.domain.LoginUserDetails;
import com.github.kkimishima.simple_todo.domain.Users;
import com.github.kkimishima.simple_todo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersDetailsService implements UserDetailsService {
  private UsersRepository usersRepository;

  @Autowired
  public UsersDetailsService(
      UsersRepository usersRepository
  ) {
    this.usersRepository = usersRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    Users users = usersRepository.findByName(s);
    if (users == null){
      throw new UsernameNotFoundException("The requested user is not found.");
    }
    return new LoginUserDetails(users);
  }
}
