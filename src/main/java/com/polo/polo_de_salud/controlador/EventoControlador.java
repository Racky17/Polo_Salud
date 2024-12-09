package com.polo.polo_de_salud.controlador;

import com.polo.polo_de_salud.modelo.eventoModelo;
import com.polo.polo_de_salud.repositorio.eventoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventoControlador {

    @Autowired
    private eventoRepositorio eventoRepo;

    @GetMapping
    public List<eventoModelo> obtenerEventos() {
        return eventoRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<eventoModelo> obtenerEventoPorId(@PathVariable Long id) {
        return eventoRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public eventoModelo crearEvento(@RequestBody eventoModelo evento) {
        return eventoRepo.save(evento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<eventoModelo> actualizarEvento(@PathVariable Long id, @RequestBody eventoModelo evento) {
        if (!eventoRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        evento.setId(id);
        return ResponseEntity.ok(eventoRepo.save(evento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEvento(@PathVariable Long id) {
        if (!eventoRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        eventoRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
