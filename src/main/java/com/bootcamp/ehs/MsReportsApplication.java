package com.bootcamp.ehs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsReportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsReportsApplication.class, args);
	}

}
