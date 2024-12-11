package com.polo.polo_de_salud.Servicio_Tests;

import com.polo.polo_de_salud.modelo.usuariosModelo;
import com.polo.polo_de_salud.repositorio.usuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Define the usuariosServicio class
@Service
public class usuariosServicio {

    @Autowired
    private usuarioRepositorio usuarioRepo;

    public Optional<usuariosModelo> obtenerUsuarioPorId(Long id) {
        return usuarioRepo.findById(id);
    }

    public usuariosModelo crearUsuario(usuariosModelo usuario) {
        return usuarioRepo.save(usuario);
    }

    // Add other required methods as necessary
}
