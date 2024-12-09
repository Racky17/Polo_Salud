package com.polo.polo_de_salud.servicio;

import com.polo.polo_de_salud.modelo.noticiaModelo;
import com.polo.polo_de_salud.repositorio.noticiaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class noticiaServicio {

    @Autowired
    private noticiaRepositorio noticiaRepo;

    public List<noticiaModelo> obtenerNoticias() {
        return noticiaRepo.findAll();
    }

    public Optional<noticiaModelo> obtenerNoticiaPorId(Long id) {
        return noticiaRepo.findById(id);
    }

    public noticiaModelo crearNoticia(noticiaModelo noticia) {
        return noticiaRepo.save(noticia);
    }

    public Optional<noticiaModelo> actualizarNoticia(Long id, noticiaModelo noticia) {
        if (noticiaRepo.existsById(id)) {
            noticia.setId(id);
            return Optional.of(noticiaRepo.save(noticia));
        }
        return Optional.empty();
    }

    public void eliminarNoticia(Long id) {
        noticiaRepo.deleteById(id);
    }
}