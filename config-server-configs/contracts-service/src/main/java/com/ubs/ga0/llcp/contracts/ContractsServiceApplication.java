package com.ubs.ga0.llcp.contracts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
)
@EnableDiscoveryClient
@EnableCircuitBreaker
public class ContractsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContractsServiceApplication.class, args);
	}

	// dummy service
	@Bean
	Function<String, String> hello() {
		return s -> "hello from contracts service - " + s;
	}
}
