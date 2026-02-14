package com.starttohkar;

import com.starttohkar.entity.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@RestController
public class SpringBootK8sCourseServiceExampleApplication {

	@GetMapping("/allCourses")
	public List<Course> viewCourses() {
		return Stream.of(
				new Course("C0011", "Java Basics", 199.99),
				new Course("C0022", "Spring Boot Mastery", 299.99),
				new Course("C0033", "Angular for Beginners", 249.99),
				new Course("C0044", "Microservices Architecture", 399.99),
				new Course("C0055", "Kubernetes for Developers", 349.99)
		).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootK8sCourseServiceExampleApplication.class, args);
	}

}
