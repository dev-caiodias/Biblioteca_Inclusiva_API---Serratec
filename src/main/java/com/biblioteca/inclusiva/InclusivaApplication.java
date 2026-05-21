package com.biblioteca.inclusiva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class InclusivaApplication {

	public static void main(String[] args) {
		SpringApplication.run(InclusivaApplication.class, args);
	}

}
