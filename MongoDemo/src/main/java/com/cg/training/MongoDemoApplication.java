package com.cg.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MongoDemoApplication {

	public static void main(final String[] args) {
		SpringApplication.run(MongoDemoApplication.class, args);
	}
}
