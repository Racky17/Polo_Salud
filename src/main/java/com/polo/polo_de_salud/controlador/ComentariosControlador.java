package com.polo.polo_de_salud.controlador;

import com.polo.polo_de_salud.modelo.comentariosModelo;
import com.polo.polo_de_salud.repositorio.comentariosRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comentarios")
public class ComentariosControlador<S> {

    @Autowired
    private comentariosRepositorio comentariosRepo;

    @GetMapping
    public List<comentariosModelo> obtenerComentarios() {
        return comentariosRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<comentariosModelo> obtenerComentarioPorId(@PathVariable Long id) {
        return comentariosRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @SuppressWarnings("unchecked")
	@PostMapping
    public comentariosModelo crearComentario(@RequestBody comentariosModelo comentario, Object com) {
        return comentariosRepo.saveAll((S) com);
    }

    @PutMapping("/{id}")
    public ResponseEntity<comentariosModelo> actualizarComentario(@PathVariable Long id, @RequestBody comentariosModelo comentario) {
        if (!comentariosRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        comentario.setId(id);
        return ResponseEntity.ok(comentariosRepo.save(comentario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarComentario(@PathVariable Long id) {
        if (!comentariosRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        comentariosRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}