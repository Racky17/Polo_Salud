package com.polo.polo_de_salud.servicio;

import com.polo.polo_de_salud.modelo.comentariosModelo;
import com.polo.polo_de_salud.repositorio.comentariosRepositorio;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class comentariosServiciosTest {

    @InjectMocks
    private comentariosServicios comentariosService;

    @Mock
    private comentariosRepositorio comentariosRepo;

    public comentariosServiciosTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obtenerComentarios() {
        comentariosModelo comentario1 = new comentariosModelo();
        comentario1.setId(1L);

        when(comentariosRepo.findAll()).thenReturn(Arrays.asList(comentario1));

        List<comentariosModelo> comentarios = comentariosService.obtenerComentarios();
        assertEquals(1, comentarios.size());
    }

    @Test
    void obtenerComentarioPorId() {
        comentariosModelo comentario = new comentariosModelo();
        comentario.setId(1L);
        when(comentariosRepo.findById(1L)).thenReturn(Optional.of(comentario));

        Optional<comentariosModelo> found = comentariosService.obtenerComentarioPorId(1L);
        assertTrue(found.isPresent());
        assertEquals(1L, found.get().getId());
    }

    @Test
    void crearComentario() {
        comentariosModelo comentario = new comentariosModelo();
        when(comentariosRepo.save(comentario)).thenReturn(comentario);

        comentariosModelo created = comentariosService.crearComentario(comentario);
        assertNotNull(created);
    }

    @Test
    void actualizarComentario() {
        comentariosModelo comentario = new comentariosModelo();
        comentario.setId(1L);

        when(comentariosRepo.existsById(1L)).thenReturn(true);
        when(comentariosRepo.save(comentario)).thenReturn(comentario);

        Optional<comentariosModelo> updated = comentariosService.actualizarComentario(1L, comentario);
        assertTrue(updated.isPresent());
    }

    @Test
    void eliminarComentario() {
        doNothing().when(comentariosRepo).deleteById(1L);
        comentariosService.eliminarComentario(1L);
        verify(comentariosRepo, times(1)).deleteById(1L);
    }
}
