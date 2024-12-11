package com.polo.polo_de_salud.Servicio_Tests;

import com.polo.polo_de_salud.modelo.administradorModelo;
import com.polo.polo_de_salud.repositorio.administradorRepositorio;
import com.polo.polo_de_salud.servicio.administradorServicio;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AdministradorServicioTest {

    @InjectMocks
    private administradorServicio servicio;

    @Mock
    private administradorRepositorio repositorio;

    public AdministradorServicioTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testObtenerAdministradorPorId() {
        administradorModelo admin = new administradorModelo();
        admin.setId(1L);
        when(repositorio.findById(1L)).thenReturn(Optional.of(admin));

        Optional<administradorModelo> result = servicio.obtenerAdministradorPorId(1L);
        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
    }

    @Test
    public void testCrearAdministrador() {
        administradorModelo admin = new administradorModelo();
        admin.setUsername("admin");
        when(repositorio.save(admin)).thenReturn(admin);

        administradorModelo result = servicio.crearAdministrador(admin);
        assertEquals("admin", result.getUsername());
    }
}