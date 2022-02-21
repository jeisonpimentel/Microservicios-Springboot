package com.microservicios.app.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.udy.commons.alumnos.entity"})
public class UdyMicroUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdyMicroUsuariosApplication.class, args);
	}

}
