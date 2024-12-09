package com.polo.polo_de_salud.servicio;

import com.polo.polo_de_salud.modelo.carrerasModelo;
import com.polo.polo_de_salud.repositorio.carrerasRepositorio;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class carrerasServicioTest {

    @InjectMocks
    private carrerasServicio carrerasService;

    @Mock
    private carrerasRepositorio carrerasRepo;

    public carrerasServicioTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obtenerCarreras() {
        carrerasModelo carrera1 = new carrerasModelo();
        carrera1.setIdCarrera(1L);
        carrera1.setNombreCarrera("Carrera 1");

        when(carrerasRepo.findAll()).thenReturn(Arrays.asList(carrera1));

        List<carrerasModelo> carreras = carrerasService.obtenerCarreras();
        assertEquals(1, carreras.size());
        assertEquals("Carrera 1", carreras.get(0).getNombreCarrera());
    }

    @Test
    void obtenerCarreraPorId() {
        carrerasModelo carrera = new carrerasModelo();
        carrera.setIdCarrera(1L);
        when(carrerasRepo.findById(1L)).thenReturn(Optional.of(carrera));

        Optional<carrerasModelo> found = carrerasService.obtenerCarreraPorId(1L);
        assertTrue(found.isPresent());
        assertEquals(1L, found.get().getIdCarrera());
    }

    @Test
    void crearCarrera() {
        carrerasModelo carrera = new carrerasModelo();
        carrera.setNombreCarrera("Nueva Carrera");
        when(carrerasRepo.save(carrera)).thenReturn(carrera);

        carrerasModelo created = carrerasService.crearCarrera(carrera);
        assertEquals("Nueva Carrera", created.getNombreCarrera());
    }

    @Test
    void actualizarCarrera() {
        carrerasModelo carrera = new carrerasModelo();
        carrera.setIdCarrera(1L);
        carrera.setNombreCarrera("Carrera Actualizada");

        when(carrerasRepo.existsById(1L)).thenReturn(true);
        when(carrerasRepo.save(carrera)).thenReturn(carrera);

        Optional<carrerasModelo> updated = carrerasService.actualizarCarrera(1L, carrera);
        assertTrue(updated.isPresent());
        assertEquals("Carrera Actualizada", updated.get().getNombreCarrera());
    }

    @Test
    void eliminarCarrera() {
        doNothing().when(carrerasRepo).deleteById(1L);
        carrerasService.eliminarCarrera(1L);
        verify(carrerasRepo, times(1)).deleteById(1L);
    }
}