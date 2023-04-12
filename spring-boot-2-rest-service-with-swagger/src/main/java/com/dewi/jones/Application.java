package com.dewi.jones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.out.println("DEWI RUN");

		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(Application.class)
				.properties("spring.config.name:application")
				.build()
				.run(args);
	}
}
