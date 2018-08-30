package com.github.kkimishima.simple_todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class SimpleTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleTodoApplication.class, args);
	}
}
