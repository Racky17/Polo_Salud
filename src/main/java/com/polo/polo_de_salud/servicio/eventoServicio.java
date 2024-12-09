package com.polo.polo_de_salud.servicio;

import com.polo.polo_de_salud.modelo.eventoModelo;
import com.polo.polo_de_salud.repositorio.eventoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class eventoServicio {

    @Autowired
    private eventoRepositorio eventoRepo;

    public List<eventoModelo> obtenerEventos() {
        return eventoRepo.findAll();
    }

    public Optional<eventoModelo> obtenerEventoPorId(Long id) {
        return eventoRepo.findById(id);
    }

    public eventoModelo crearEvento(eventoModelo evento) {
        return eventoRepo.save(evento);
    }

    public Optional<eventoModelo> actualizarEvento(Long id, eventoModelo evento) {
        if (eventoRepo.existsById(id)) {
            evento.setId(id);
            return Optional.of(eventoRepo.save(evento));
        }
        return Optional.empty();
    }

    public void eliminarEvento(Long id) {
        eventoRepo.deleteById(id);
    }
}
