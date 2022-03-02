package com.udy.micro.cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.udy.commons.alumnos.entity",
			 "com.udy.micro.cursos.entity",
			 "com.udy.commons.examenes.entity"})
public class UdyMicroCursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdyMicroCursosApplication.class, args);
	}

}
