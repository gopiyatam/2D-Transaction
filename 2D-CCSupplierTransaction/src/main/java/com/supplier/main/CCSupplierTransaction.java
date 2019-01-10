package com.supplier.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="/com.supplier")
public class CCSupplierTransaction {

	public static void main(String[] args) {
		SpringApplication.run(CCSupplierTransaction.class, args);

	}

}
