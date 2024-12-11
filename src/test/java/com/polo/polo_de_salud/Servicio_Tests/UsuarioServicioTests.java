package com.polo.polo_de_salud.Servicio_Tests;

import com.polo.polo_de_salud.modelo.usuariosModelo;
import com.polo.polo_de_salud.repositorio.usuarioRepositorio;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UsuarioServicioTests {

    @InjectMocks
    private usuariosServicio servicio;

    @Mock
    private usuarioRepositorio usuarioRepo;

    public UsuarioServicioTests() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testObtenerUsuarioPorId() {
        usuariosModelo usuario = new usuariosModelo();
        usuario.setIdUsuario(1);
        when(usuarioRepo.findById(1L)).thenReturn(Optional.of(usuario));

        Optional<usuariosModelo> result = servicio.obtenerUsuarioPorId(1L);
        assertTrue(result.isPresent());
        assertEquals(1, result.get().getIdUsuario());
    }

    @Test
    public void testCrearUsuario() {
        usuariosModelo usuario = new usuariosModelo();
        usuario.setName("usuario");
        when(usuarioRepo.save(usuario)).thenReturn(usuario);

        usuariosModelo result = servicio.crearUsuario(usuario);
        assertEquals("usuario", result.getName());
    }
}