package com.cg.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class BootTransactionApplication {

	public static void main(final String[] args) {
		SpringApplication.run(BootTransactionApplication.class, args);
	
	}
	

	
}
