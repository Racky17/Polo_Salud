package com.polo.polo_de_salud.controlador;

import com.polo.polo_de_salud.modelo.proyectosModelo;
import com.polo.polo_de_salud.repositorio.proyectoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoControlador<proyectos> {

    @Autowired
    private proyectoRepositorio proyectoRepo;

    @GetMapping
    public List<proyectosModelo> obtenerProyectos() {
        return proyectoRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<proyectosModelo> obtenerProyectoPorId(@PathVariable Long id) {
        return proyectoRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public proyectosModelo crearProyecto(@RequestBody proyectosModelo proyecto) {
        return proyectoRepo.save(proyecto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<proyectosModelo> actualizarProyecto(@PathVariable Long id, @RequestBody proyectosModelo proyecto) {
        if (!proyectoRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        proyecto.setId(id);
        return ResponseEntity.ok(proyectoRepo.save(proyecto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProyecto(@PathVariable Long id) {
        if (!proyectoRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        proyectoRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}