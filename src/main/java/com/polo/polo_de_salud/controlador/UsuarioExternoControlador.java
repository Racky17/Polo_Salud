package com.polo.polo_de_salud.controlador;

import com.polo.polo_de_salud.modelo.usuarioexternoModelo;
import com.polo.polo_de_salud.repositorio.usuarioexternoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios-externos")
public class UsuarioExternoControlador {

    @Autowired
    private usuarioexternoRepositorio usuarioExternoRepo;

    @GetMapping
    public List<usuarioexternoModelo> obtenerUsuariosExternos() {
        return usuarioExternoRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<usuarioexternoModelo> obtenerUsuarioExternoPorId(@PathVariable Long id) {
        return usuarioExternoRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public usuarioexternoModelo crearUsuarioExterno(@RequestBody usuarioexternoModelo usuarioExterno) {
        return usuarioExternoRepo.save(usuarioExterno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<usuarioexternoModelo> actualizarUsuarioExterno(@PathVariable Long id, @RequestBody usuarioexternoModelo usuarioExterno) {
        if (!usuarioExternoRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        usuarioExterno.setId(id);
        return ResponseEntity.ok(usuarioExternoRepo.save(usuarioExterno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuarioExterno(@PathVariable Long id) {
        if (!usuarioExternoRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        usuarioExternoRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
