package com.github.kkimishima.simple_todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers("/loginForm","/spa/**","/api","/api/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin().loginProcessingUrl("/login")
        .loginPage("/loginForm")
        .failureUrl("/loginForm?error")
        .defaultSuccessUrl("/demo", true)
        .usernameParameter("username").passwordParameter("password")
        .and()
        .logout()
        .logoutSuccessUrl("/loginForm");
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/js/**");
  }
  @Bean
  PasswordEncoder passwordEncoder() {
    return new Pbkdf2PasswordEncoder();
  }
}
