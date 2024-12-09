package com.polo.polo_de_salud.modelo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class proyectosModelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String nombre;
private LocalDate fechainicio;
private LocalDate fechafin;
private String estado;


public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public LocalDate getFechainicio() {
	return fechainicio;
}
public void setFechainicio(LocalDate fechainicio) {
	this.fechainicio = fechainicio;
}
public LocalDate getFechafin() {
	return fechafin;
}
public void setFechafin(LocalDate fechafin) {
	this.fechafin = fechafin;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
} 



}
