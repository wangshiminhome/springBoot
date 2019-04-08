package com.wsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement//开启事务
public class Springboot03Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot03Application.class, args);
	}

}

