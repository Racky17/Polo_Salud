package com.polo.polo_de_salud.controlador;

import com.polo.polo_de_salud.modelo.centrosModelo;
import com.polo.polo_de_salud.repositorio.centrosRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/centros")
public class CentrosControlador {

    @Autowired
    private centrosRepositorio centrosRepo;

    @GetMapping
    public List<centrosModelo> obtenerCentros() {
        return centrosRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<centrosModelo> obtenerCentroPorId(@PathVariable Long id) {
        return centrosRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public centrosModelo crearCentro(@RequestBody centrosModelo centro) {
        return centrosRepo.save(centro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<centrosModelo> actualizarCentro(@PathVariable Long id, @RequestBody centrosModelo centro) {
        if (!centrosRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        centro.setId(id);
        return ResponseEntity.ok(centrosRepo.save(centro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCentro(@PathVariable Long id) {
        if (!centrosRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        centrosRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
