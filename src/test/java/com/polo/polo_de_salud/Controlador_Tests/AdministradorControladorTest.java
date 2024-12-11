package com.polo.polo_de_salud.Controlador_Tests;

import com.polo.polo_de_salud.controlador.AdministradorControlador;
import com.polo.polo_de_salud.modelo.administradorModelo;
import com.polo.polo_de_salud.servicio.administradorServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.unmodifiableList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AdministradorControladorTest {

    @InjectMocks
    private AdministradorControlador controlador;

    @Mock
    private administradorServicio servicio;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testObtenerAdministradores() {
        administradorModelo admin = new administradorModelo();
        admin.setId(1L);
        when(servicio.obtenerAdministradores()).thenReturn(Collections.singletonList(admin));

        List<administradorModelo> result;
        result = unmodifiableList(controlador.obtenerAdministradores());
        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).getId());
    }

    @Test
    public void testCrearAdministrador() {
        administradorModelo admin = new administradorModelo();
        admin.setUsername("admin");
        when(servicio.crearAdministrador(admin)).thenReturn(admin);

        administradorModelo result;
        result = controlador.crearAdministrador(admin);
        assertEquals("admin", result.getUsername());
    }
}