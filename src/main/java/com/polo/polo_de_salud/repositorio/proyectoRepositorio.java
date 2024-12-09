package com.polo.polo_de_salud.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.polo.polo_de_salud.modelo.proyectosModelo;

@Repository
public interface proyectoRepositorio extends JpaRepository<proyectosModelo, Long> {

}
