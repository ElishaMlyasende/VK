package com.example.OffficeOperation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OffficeOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(OffficeOperationApplication.class, args);
	}

}
