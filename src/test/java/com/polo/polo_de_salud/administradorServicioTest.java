package com.polo.polo_de_salud;

import com.polo.polo_de_salud.modelo.administradorModelo;
import com.polo.polo_de_salud.repositorio.administradorRepositorio;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class administradorServicioTest {

    @InjectMocks
    private administradorServicio administradorService;

    @Mock
    private administradorRepositorio administradorRepo;

    public administradorServicioTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obtenerAdministradores() {
        administradorModelo admin1 = new administradorModelo();
        admin1.setId(1L);
        admin1.setName("Admin 1");

        when(administradorRepo.findAll()).thenReturn(Arrays.asList(admin1));

        List<administradorModelo> admins = administradorService.obtenerAdministradores();
        assertEquals(1, admins.size());
        assertEquals("Admin 1", admins.get(0).getName());
    }

    @Test
    void obtenerAdministradorPorId() {
        administradorModelo admin = new administradorModelo();
        admin.setId(1L);
        when(administradorRepo.findById(1L)).thenReturn(Optional.of(admin));

        Optional<administradorModelo> found = administradorService.obtenerAdministradorPorId(1L);
        assertTrue(found.isPresent());
        assertEquals(1L, found.get().getId());
    }

    @Test
    void crearAdministrador() {
        administradorModelo admin = new administradorModelo();
        admin.setName("Nuevo Admin");
        when(administradorRepo.save(admin)).thenReturn(admin);

        administradorModelo created = administradorService.crearAdministrador(admin);
        assertEquals("Nuevo Admin", created.getName());
    }

    @Test
    void actualizarAdministrador() {
        administradorModelo admin = new administradorModelo();
 ```java
        admin.setId(1L);
        admin.setName("Admin Actualizado");

        when(administradorRepo.existsById(1L)).thenReturn(true);
        when(administradorRepo.save(admin)).thenReturn(admin);

        Optional<administradorModelo> updated = administradorService.actualizarAdministrador(1L, admin);
        assertTrue(updated.isPresent());
        assertEquals("Admin Actualizado", updated.get().getName());
    }

    @Test
    void eliminarAdministrador() {
        doNothing().when(administradorRepo).deleteById(1L);
        administradorService.eliminarAdministrador(1L);
        verify(administradorRepo, times(1)).deleteById(1L);
    }
}