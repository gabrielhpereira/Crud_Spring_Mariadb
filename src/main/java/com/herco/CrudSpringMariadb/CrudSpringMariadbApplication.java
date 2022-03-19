package com.herco.CrudSpringMariadb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.herco.CrudSpringMariadb")
@EntityScan(basePackages = "com.herco.CrudSpringMariadb.model")
public class CrudSpringMariadbApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringMariadbApplication.class, args);
	}

}
