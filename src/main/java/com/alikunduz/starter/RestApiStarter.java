package com.alikunduz.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.alikunduz"})
@EnableJpaRepositories(basePackages = {"com.alikunduz"})
@ComponentScan(basePackages = {"com.alikunduz"})
@SpringBootApplication
public class RestApiStarter {

	public static void main(String[] args) {
		SpringApplication.run(RestApiStarter.class, args);
	}

}
