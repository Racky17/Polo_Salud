package com.polo.polo_de_salud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@SpringBootApplication
public class ProyectoPoloDeSaludApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoPoloDeSaludApplication.class, args);
	}

}
