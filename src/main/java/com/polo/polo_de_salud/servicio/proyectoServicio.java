package com.polo.polo_de_salud.servicio;

import com.polo.polo_de_salud.modelo.proyectosModelo;
import com.polo.polo_de_salud.repositorio.proyectoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class proyectoServicio {

    @Autowired
    private proyectoRepositorio proyectoRepo;

    public List<proyectosModelo> obtenerProyectos() {
        return proyectoRepo.findAll();
    }

    public Optional<proyectosModelo> obtenerProyectoPorId(Long id) {
        return proyectoRepo.findById(id);
    }

    public proyectosModelo crearProyecto(proyectosModelo proyecto) {
        return proyectoRepo.save(proyecto);
    }

    public Optional<proyectosModelo> actualizarProyecto(Long id, proyectosModelo proyecto) {
        if (proyectoRepo.existsById(id)) {
            proyecto.setId(id);
            return Optional.of(proyectoRepo.save(proyecto));
        }
        return Optional.empty();
    }

    public void eliminarProyecto(Long id) {
        proyectoRepo.deleteById(id);
    }
}