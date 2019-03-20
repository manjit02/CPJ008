package com.taskmanager.tsk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.taskmanager.tsk")
//@EntityScan(basePackages = {"com.taskmanager.tsk.entity"})
public class TskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TskApplication.class, args);
	}
}
