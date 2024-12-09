package com.polo.polo_de_salud.servicio;

import com.polo.polo_de_salud.modelo.documentoModelo;
import com.polo.polo_de_salud.repositorio.documentoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class documentoServicio {

    @Autowired
    private documentoRepositorio documentoRepo;

    public List<documentoModelo> obtenerDocumentos() {
        return documentoRepo.findAll();
    }

    public Optional<documentoModelo> obtenerDocumentoPorId(Long id) {
        return documentoRepo.findById(id);
    }

    public documentoModelo crearDocumento(documentoModelo documento) {
        return documentoRepo.save(documento);
    }

    public Optional<documentoModelo> actualizarDocumento(Long id, documentoModelo documento) {
        if (documentoRepo.existsById(id)) {
            documento.setId(id);
            return Optional.of(documentoRepo.save(documento));
        }
        return Optional.empty();
    }

    public void eliminarDocumento(Long id) {
        documentoRepo.deleteById(id);
    }
}