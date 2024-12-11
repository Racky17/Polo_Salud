package com.polo.polo_de_salud.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.polo.polo_de_salud.modelo.usuariosModelo;

import java.util.Optional;

public interface usuarioRepositorio extends JpaRepository <usuariosModelo, Long>{

    default boolean existsById(Integer ignoredId) {
        return false;
    }

    default Optional<usuariosModelo> findById(Integer ignoredId) {
        return Optional.empty();
    }
}
