package com.starttohkar;

import com.starttohkar.entity.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@RestController
@RequestMapping("/customers")
public class SpringBootK8sHelmExampleApplication {

	@GetMapping
	public List<Customer> getCustomers() {
		return Stream.of(new Customer(101, "10.100.123.987", "Male","umesh@gmail.com", "Kumar", "Umesh" ),
						new Customer(102, "10.100.123.117", "Male","kishore@gmail.com", "Kumar", "Kishore" ),
						new Customer(103, "10.100.123.716", "Female","maana@gmail.com", "Kumari", "Maana" ))
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootK8sHelmExampleApplication.class, args);
	}

}
