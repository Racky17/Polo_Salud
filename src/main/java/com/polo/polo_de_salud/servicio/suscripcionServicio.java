package com.polo.polo_de_salud.servicio;

import com.polo.polo_de_salud.modelo.suscripcionModelo;
import com.polo.polo_de_salud.repositorio.suscripcionRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class suscripcionServicio {

    @Autowired
    private suscripcionRepositorio suscripcionRepo;

    public List<suscripcionModelo> obtenerSuscripciones() {
        return suscripcionRepo.findAll();
    }

    public Optional<suscripcionModelo> obtenerSuscripcionPorId(Long id) {
        return suscripcionRepo.findById(id);
    }

    public suscripcionModelo crearSuscripcion(suscripcionModelo suscripcion) {
        return suscripcionRepo.save(suscripcion);
    }

    public Optional<suscripcionModelo> actualizarSuscripcion(Long id, suscripcionModelo suscripcion) {
        if (suscripcionRepo.existsById(id)) {
            suscripcion.setId(id);
            return Optional.of(suscripcionRepo.save(suscripcion));
        }
        return Optional.empty();
    }

    public void eliminarSuscripcion(Long id) {
        suscripcionRepo.deleteById(id);
    }
}
