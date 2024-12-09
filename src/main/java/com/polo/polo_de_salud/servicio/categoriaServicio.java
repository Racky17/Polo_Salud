package com.polo.polo_de_salud.servicio;

import com.polo.polo_de_salud.modelo.categoriaModelo;
import com.polo.polo_de_salud.repositorio.categoriaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class categoriaServicio {

    @Autowired
    private categoriaRepositorio categoriaRepo;

    public List<categoriaModelo> obtenerCategorias() {
        return categoriaRepo.findAll();
    }

    public Optional<categoriaModelo> obtenerCategoriaPorId(Long id) {
        return categoriaRepo.findById(id);
    }

    public categoriaModelo crearCategoria(categoriaModelo categoria) {
        return categoriaRepo.save(categoria);
    }

    public Optional<categoriaModelo> actualizarCategoria(Long id, categoriaModelo categoria) {
        if (categoriaRepo.existsById(id)) {
            categoria.setId(id);
            return Optional.of(categoriaRepo.save(categoria));
        }
        return Optional.empty();
    }

    public void eliminarCategoria(Long id) {
        categoriaRepo.deleteById(id);
    }
}