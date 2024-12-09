package com.polo.polo_de_salud.servicio;

import com.polo.polo_de_salud.modelo.documentoModelo;
import com.polo.polo_de_salud.repositorio.documentoRepositorio;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class documentoServicioTest {

    @InjectMocks
    private documentoServicio documentoService;

    @Mock
    private documentoRepositorio documentoRepo;

    public documentoServicioTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obtenerDocumentos() {
        documentoModelo documento1 = new documentoModelo();
        documento1.setId(1L);

        when(documentoRepo.findAll()).thenReturn(Arrays.asList(documento1));

        List<documentoModelo> documentos = documentoService.obtenerDocumentos();
        assertEquals(1, documentos.size());
    }

    @Test
    void obtenerDocumentoPorId() {
        documentoModelo documento = new documentoModelo();
        documento.setId(1L);
        when(documentoRepo.findById(1L)).thenReturn(Optional.of(documento));

        Optional<documentoModelo> found = documentoService.obtenerDocumentoPorId(1L);
        assertTrue(found.isPresent());
        assertEquals(1L, found.get().getId());
    }

    @Test
    void crearDocumento() {
        documentoModelo documento = new documentoModelo();
        when(documentoRepo.save(documento)).thenReturn(documento);

        documentoModelo created = documentoService.crearDocumento(documento);
        assertNotNull(created);
    }

    @Test
    void actualizarDocumento() {
        documentoModelo documento = new documentoModelo();
        documento.setId(1L);

        when(documentoRepo.existsById(1L)).thenReturn(true);
        when(documentoRepo.save(documento)).thenReturn(documento);

        Optional<documentoModelo> updated = documentoService.actualizarDocumento(1L, documento);
        assertTrue(updated.isPresent());
    }

    @Test
    void eliminarDocumento() {
        doNothing().when(documentoRepo).deleteById(1L);
        documentoService.eliminarDocumento(1L);
        verify(documentoRepo, times(1)).deleteById(1L);
    }
}