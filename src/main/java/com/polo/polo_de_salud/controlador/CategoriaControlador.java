package com.polo.polo_de_salud.controlador;

import com.polo.polo_de_salud.modelo.categoriaModelo;
import com.polo.polo_de_salud.repositorio.categoriaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaControlador {

    @Autowired
    private categoriaRepositorio categoriaRepo;

    @GetMapping
    public List<categoriaModelo> obtenerCategorias() {
        return categoriaRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<categoriaModelo> obtenerCategoriaPorId(@PathVariable Long id) {
        return categoriaRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public categoriaModelo crearCategoria(@RequestBody categoriaModelo categoria) {
        return categoriaRepo.save(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<categoriaModelo> actualizarCategoria(@PathVariable Long id, @RequestBody categoriaModelo categoria) {
        if (!categoriaRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        categoria.setId(id);
        return ResponseEntity.ok(categoriaRepo.save(categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id) {
        if (!categoriaRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        categoriaRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}