package com.polo.polo_de_salud.servicio;

import com.polo.polo_de_salud.modelo.administradorModelo;
import com.polo.polo_de_salud.repositorio.administradorRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class administradorServicio {

    @Autowired
    private administradorRepositorio administradorRepo;

    public List<administradorModelo> obtenerAdministradores() {
        return administradorRepo.findAll();
    }

    public Optional<administradorModelo> obtenerAdministradorPorId(Long id) {
        return administradorRepo.findById(id);
    }

    public administradorModelo crearAdministrador(administradorModelo administrador) {
        return administradorRepo.save(administrador);
    }

    public Optional<administradorModelo> actualizarAdministrador(Long id, administradorModelo administrador) {
        if (administradorRepo.existsById(id)) {
            administrador.setId(id);
            return Optional.of(administradorRepo.save(administrador));
        }
        return Optional.empty();
    }

    public void eliminarAdministrador(Long id) {
        administradorRepo.deleteById(id);
    }
}