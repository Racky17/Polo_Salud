package com.polo.polo_de_salud.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.polo.polo_de_salud.modelo.eventoModelo;

public interface eventoRepositorio extends JpaRepository <eventoModelo, Long> {

}
