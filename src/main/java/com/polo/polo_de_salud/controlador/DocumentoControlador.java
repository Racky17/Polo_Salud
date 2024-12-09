package com.polo.polo_de_salud.controlador;

import com.polo.polo_de_salud.modelo.documentoModelo;
import com.polo.polo_de_salud.repositorio.documentoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documentos")
public class DocumentoControlador {

    @Autowired
    private documentoRepositorio documentoRepo;

    @GetMapping
    public List<documentoModelo> obtenerDocumentos() {
        return documentoRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<documentoModelo> obtenerDocumentoPorId(@PathVariable Long id) {
        return documentoRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public documentoModelo crearDocumento(@RequestBody documentoModelo documento) {
        return documentoRepo.save(documento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<documentoModelo> actualizarDocumento(@PathVariable Long id, @RequestBody documentoModelo documento) {
        if (!documentoRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        documento.setId(id);
        return ResponseEntity.ok(documentoRepo.save(documento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDocumento(@PathVariable Long id) {
        if (!documentoRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        documentoRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
