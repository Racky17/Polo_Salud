package com.polo.polo_de_salud.servicio;

import com.polo.polo_de_salud.modelo.centrosModelo;
import com.polo.polo_de_salud.repositorio.centrosRepositorio;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class centrosServiciosTest {

    @InjectMocks
    private centrosServicios centrosService;

    @Mock
    private centrosRepositorio centrosRepo;

    public centrosServiciosTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obtenerCentros() {
        centrosModelo centro1 = new centrosModelo();
        centro1.setId(1L);

        when(centrosRepo.findAll()).thenReturn(Arrays.asList(centro1));

        List<centrosModelo> centros = centrosService.obtenerCentros();
        assertEquals(1, centros.size());
    }

    @Test
    void obtenerCentroPorId() {
        centrosModelo centro = new centrosModelo();
        centro.setId(1L);
        when(centrosRepo.findById(1L)).thenReturn(Optional.of(centro));

        Optional<centrosModelo> found = centrosService.obtenerCentroPorId(1L);
        assertTrue(found.isPresent());
        assertEquals(1L, found.get().getId());
    }

    @Test
    void crearCentro() {
        centrosModelo centro = new centrosModelo();
        when(centrosRepo.save(centro)).thenReturn(centro);

        centrosModelo created = centrosService.crearCentro(centro);
        assertNotNull(created);
    }

    @Test
    void actualizarCentro() {
        centrosModelo centro = new centrosModelo();
        centro.setId(1L);

        when(centrosRepo.existsById(1L)).thenReturn(true);
        when(centrosRepo.save(centro)).thenReturn(centro);

        Optional<centrosModelo> updated = centrosService.actualizarCentro(1L, centro);
        assertTrue(updated.isPresent());
    }

    @Test
    void eliminarCentro() {
        doNothing().when(centrosRepo).deleteById(1L);
        centrosService.eliminarCentro(1L);
        verify(centrosRepo, times(1)).deleteById(1L);
    }
}