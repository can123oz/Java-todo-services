package com.todolist.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

}


// docker run --rm -it -p 15672:15672 -p 5672:5672 rabbitmq:3.13.0-rc.1-management
// docker run --name -d <cont-name> -p 5432:5432 -e POSTGRES_PASSWORD=<password> postgres