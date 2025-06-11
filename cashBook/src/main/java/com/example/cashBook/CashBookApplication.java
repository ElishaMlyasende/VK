package com.example.cashBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CashBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(CashBookApplication.class, args);
	}

}
