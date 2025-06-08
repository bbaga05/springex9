package ru.itementor.spring.boot_rest_template.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.itementor.spring.boot_rest_template.demo.Service.ApiClient;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ApiClient apiClient) {
		return args -> apiClient.runClient();
	}
}
