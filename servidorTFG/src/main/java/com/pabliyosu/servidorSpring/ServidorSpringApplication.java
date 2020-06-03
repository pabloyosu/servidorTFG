package com.pabliyosu.servidorSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

//Run
@SpringBootApplication
public class ServidorSpringApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ServidorSpringApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

	private static Class<ServidorSpringApplication> applicationClass = ServidorSpringApplication.class;

}
