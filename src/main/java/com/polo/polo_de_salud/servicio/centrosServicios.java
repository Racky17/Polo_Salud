package com.polo.polo_de_salud.servicio;

import com.polo.polo_de_salud.modelo.centrosModelo;
import com.polo.polo_de_salud.repositorio.centrosRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class centrosServicios {

    @Autowired
    private centrosRepositorio centrosRepo;

    public List<centrosModelo> obtenerCentros() {
        return centrosRepo.findAll();
    }

    public Optional<centrosModelo> obtenerCentroPorId(Long id) {
        return centrosRepo.findById(id);
    }

    public centrosModelo crearCentro(centrosModelo centro) {
        return centrosRepo.save(centro);
    }

    public Optional<centrosModelo> actualizarCentro(Long id, centrosModelo centro) {
        if (centrosRepo.existsById(id)) {
            centro.setIdCentro(id);
            return Optional.of(centrosRepo.save(centro));
        }
        return Optional.empty();
    }

    public void eliminarCentro(Long id) {
        centrosRepo.deleteById(id);
    }
}