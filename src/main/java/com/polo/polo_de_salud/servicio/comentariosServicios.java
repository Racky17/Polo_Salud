package com.polo.polo_de_salud.servicio;

import com.polo.polo_de_salud.modelo.comentariosModelo;
import com.polo.polo_de_salud.repositorio.comentariosRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class comentariosServicios {

    @Autowired
    private comentariosRepositorio comentariosRepo;

    public List<comentariosModelo> obtenerComentarios() {
        return comentariosRepo.findAll();
    }

    public Optional<comentariosModelo> obtenerComentarioPorId(Long id) {
        return comentariosRepo.findById(id);
    }

    public comentariosModelo crearComentario(comentariosModelo comentario) {
        return comentariosRepo.save(comentario);
    }

    public Optional<comentariosModelo> actualizarComentario(Long id, comentariosModelo comentario) {
        if (comentariosRepo.existsById(id)) {
            comentario.setId(id);
            return Optional.of(comentariosRepo.save(comentario));
        }
        return Optional.empty();
    }

    public void eliminarComentario(Long id) {
        comentariosRepo.deleteById(id);
    }
}