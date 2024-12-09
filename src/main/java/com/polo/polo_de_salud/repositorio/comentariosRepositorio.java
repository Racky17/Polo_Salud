package com.polo.polo_de_salud.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.polo.polo_de_salud.modelo.comentariosModelo;

public interface comentariosRepositorio extends JpaRepository <comentariosModelo, Long> {

	<S> comentariosModelo saveAll(S com);

}
