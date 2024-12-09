package com.polo.polo_de_salud.controlador;

import com.polo.polo_de_salud.modelo.suscripcionModelo;
import com.polo.polo_de_salud.repositorio.suscripcionRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suscripciones")
public class SuscripcionControlador {

    @Autowired
    private suscripcionRepositorio suscripcionRepo;

    @GetMapping
    public List<suscripcionModelo> obtenerSuscripciones() {
        return suscripcionRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<suscripcionModelo> obtenerSuscripcionPorId(@PathVariable Long id) {
        return suscripcionRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public suscripcionModelo crearSuscripcion(@RequestBody suscripcionModelo suscripcion) {
        return suscripcionRepo.save(suscripcion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<suscripcionModelo> actualizarSuscripcion(@PathVariable Long id, @RequestBody suscripcionModelo suscripcion) {
        if (!suscripcionRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        suscripcion.setId(id);
        return ResponseEntity.ok(suscripcionRepo.save(suscripcion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSuscripcion(@PathVariable Long id) {
        if (!suscripcionRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        suscripcionRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}