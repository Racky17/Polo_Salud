package com.polo.polo_de_salud.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.polo.polo_de_salud.modelo.documentoModelo;

public interface documentoRepositorio extends JpaRepository <documentoModelo, Long>{

}
