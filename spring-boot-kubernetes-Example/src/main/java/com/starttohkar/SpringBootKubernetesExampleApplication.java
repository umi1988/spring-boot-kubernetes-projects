package com.starttohkar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootKubernetesExampleApplication {

	@GetMapping("/welcome")
	public String displayMessage() {
		return "Hello from Spring Boot Kubernetes Example Application!";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKubernetesExampleApplication.class, args);
	}

}
