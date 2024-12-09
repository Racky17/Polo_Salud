package com.polo.polo_de_salud.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.polo.polo_de_salud.modelo.investigadorModelo;
import com.polo.polo_de_salud.servicio.InvestigadorServicio;

public interface investigadorRepositorio extends JpaRepository <investigadorModelo, Long>{

	InvestigadorServicio save(InvestigadorServicio investigador);

}
