package com.polo.polo_de_salud.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class centrosModelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long Id;

	public void setId(Long id2) {
	}

	public void setIdCentro(Long id2) {
		
	}
}
