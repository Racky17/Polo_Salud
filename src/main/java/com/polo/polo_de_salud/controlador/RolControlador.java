package com.polo.polo_de_salud.controlador;

import com.polo.polo_de_salud.modelo.rolModelo;
import com.polo.polo_de_salud.repositorio.rolRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolControlador {

    @Autowired
    private rolRepositorio rolRepo;

    @GetMapping
    public List<rolModelo> obtenerRoles() {
        return rolRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<rolModelo> obtenerRolPorId(@PathVariable Long id) {
        return rolRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public rolModelo crearRol(@RequestBody rolModelo rol) {
        return rolRepo.save(rol);
    }

    @PutMapping("/{id}")
    public ResponseEntity<rolModelo> actualizarRol(@PathVariable Long id, @RequestBody rolModelo rol) {
        if (!rolRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        rol.setId(id);
        return ResponseEntity.ok(rolRepo.save(rol));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable Long id) {
        if (!rolRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        rolRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}