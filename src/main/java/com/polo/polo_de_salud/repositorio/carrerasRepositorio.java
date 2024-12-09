package com.polo.polo_de_salud.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.polo.polo_de_salud.modelo.carrerasModelo;

@SuppressWarnings("rawtypes")
public interface carrerasRepositorio extends JpaRepository<carrerasModelo, Long> {

}
