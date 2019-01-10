package com.integration.main;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.integration")

public class CCTransactionApplication {
	public static void main(String[] args) {
		SpringApplication.run(CCTransactionApplication.class, args);
		
	}

}
