package com.polo.polo_de_salud.controlador;

import com.polo.polo_de_salud.modelo.formulariodecontactoModelo;
import com.polo.polo_de_salud.servicio.formulariodecontactoServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/formularios")
public class formulariodecontactoControlador {

    @Autowired
    private formulariodecontactoServicio formularioServicio;


    @GetMapping
    public List<formulariodecontactoModelo> obtenerFormularios() {
        return formularioServicio.obtenerFormularios();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<formulariodecontactoModelo> obtenerFormularioPorId(@PathVariable Long id) {
        Optional<formulariodecontactoModelo> formulario = formularioServicio.obtenerFormularioPorId(id);
        return formulario.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

  
    @PostMapping
    public formulariodecontactoModelo crearFormulario(@RequestBody formulariodecontactoModelo formulario) {
        return formularioServicio.crearFormulario(formulario);
    }


    @PutMapping("/{id}")
    public ResponseEntity<formulariodecontactoModelo> actualizarFormulario(@PathVariable Long id, @RequestBody formulariodecontactoModelo formulario) {
        Optional<formulariodecontactoModelo> formularioActualizado = formularioServicio.actualizarFormulario(id, formulario);
        return formularioActualizado.map(ResponseEntity::ok)
                                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

  
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFormulario(@PathVariable Long id) {
        formularioServicio.eliminarFormulario(id);
        return ResponseEntity.noContent().build();
    }
}