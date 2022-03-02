package com.udymicro.examenes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.udy.commons.examenes.entity"})
public class UdyMicroExamenesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdyMicroExamenesApplication.class, args);
	}

}
