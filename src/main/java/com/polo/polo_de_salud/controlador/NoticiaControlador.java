package com.polo.polo_de_salud.controlador;

import com.polo.polo_de_salud.modelo.noticiaModelo;
import com.polo.polo_de_salud.repositorio.noticiaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/noticias")
public class NoticiaControlador {

    @Autowired
    private noticiaRepositorio noticiaRepo;

    @GetMapping
    public List<noticiaModelo> obtenerNoticias() {
        return noticiaRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<noticiaModelo> obtenerNoticiaPorId(@PathVariable Long id) {
        return noticiaRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public noticiaModelo crearNoticia(@RequestBody noticiaModelo noticia) {
        return noticiaRepo.save(noticia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<noticiaModelo> actualizarNoticia(@PathVariable Long id, @RequestBody noticiaModelo noticia) {
        if (!noticiaRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        noticia.setId(id);
        return ResponseEntity.ok(noticiaRepo.save(noticia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNoticia(@PathVariable Long id) {
        if (!noticiaRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        noticiaRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}