package com.polo.polo_de_salud.servicio;

import com.polo.polo_de_salud.modelo.rolModelo;
import com.polo.polo_de_salud.repositorio.rolRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class rolServicio {

    @Autowired
    private rolRepositorio rolRepo;

    public List<rolModelo> obtenerRoles() {
        return rolRepo.findAll();
    }

    public Optional<rolModelo> obtenerRolPorId(Long id) {
        return rolRepo.findById(id);
    }

    public rolModelo crearRol(rolModelo rol) {
        return rolRepo.save(rol);
    }

    public Optional<rolModelo> actualizarRol(Long id, rolModelo rol) {
        if (rolRepo.existsById(id)) {
            rol.setId(id);
            return Optional.of(rolRepo.save(rol));
        }
        return Optional.empty();
    }

    public void eliminarRol(Long id) {
        rolRepo.deleteById(id);
    }
}