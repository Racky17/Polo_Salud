package com.polo.polo_de_salud.controlador;

import com.polo.polo_de_salud.modelo.administradorModelo;
import com.polo.polo_de_salud.repositorio.administradorRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administradores")
public class AdministradorControlador {

    @Autowired
    private administradorRepositorio administradorRepo;

    @GetMapping
    public List<administradorModelo> obtenerAdministradores() {
        return administradorRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<administradorModelo> obtenerAdministradorPorId(@PathVariable Long id) {
        return administradorRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public administradorModelo crearAdministrador(@RequestBody administradorModelo administrador) {
        return administradorRepo.save(administrador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<administradorModelo> actualizarAdministrador(@PathVariable Long id, @RequestBody administradorModelo administrador) {
        if (!administradorRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        administrador.setId(id);
        return ResponseEntity.ok(administradorRepo.save(administrador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAdministrador(@PathVariable Long id) {
        if (!administradorRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        administradorRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}