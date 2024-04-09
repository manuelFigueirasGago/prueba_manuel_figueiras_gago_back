package com.prueba.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.prueba.prueba.services","com.prueba.prueba.controller", "com.prueba.prueba.config"})
public class PruebaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}

}
