package com.github.kkimishima.simple_todo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(loginController.class)
//@RunWith(SpringRunner.class)
//@SpringBootTest(
//    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
//    classes = loginController.class)
@AutoConfigureMockMvc
public class loginControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  @WithMockUser
  public void testサンプルテスト() throws Exception {
    mockMvc.perform(get("/loginForm"))
        .andExpect(status().isOk());
  }
}