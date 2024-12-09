package com.polo.polo_de_salud.controlador;

import com.polo.polo_de_salud.modelo.carrerasModelo;
import com.polo.polo_de_salud.repositorio.carrerasRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carreras")
public class CarrerasControlador {

    @Autowired
    private carrerasRepositorio carrerasRepo;

    @SuppressWarnings("rawtypes")
	@GetMapping
    public List<carrerasModelo> obtenerCarreras() {
        return carrerasRepo.findAll();
    }

    @SuppressWarnings("rawtypes")
	@GetMapping("/{id}")
    public ResponseEntity<carrerasModelo> obtenerCarreraPorId(@PathVariable Long id) {
        return carrerasRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public carrerasModelo<?> crearCarrera(@RequestBody carrerasModelo<?> carrera) {
        return carrerasRepo.save(carrera);
    }

    @SuppressWarnings("rawtypes")
	@PutMapping("/{id}")
    public ResponseEntity<carrerasModelo> actualizarCarrera(@PathVariable Long id, @RequestBody carrerasModelo<?> carrera) {
        if (!carrerasRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        carrera.setIdCarrera(id);
        return ResponseEntity.ok(carrerasRepo.save(carrera));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCarrera(@PathVariable Long id) {
        if (!carrerasRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        carrerasRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}