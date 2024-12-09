package com.polo.polo_de_salud;

import com.polo.polo_de_salud.modelo.usuariosModelo;
import com.polo.polo_de_salud.repositorio.usuarioRepositorio;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties.UiService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class usuariosServicioTest {

    @InjectMocks
    private usuariosServicio usuarioService;

    @Mock
    private usuarioRepositorio usuarioRepo;

    public usuariosServicioTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obtenerUsuarios() {
        usuariosModelo usuario1 = new usuariosModelo();
        usuario1.setIdUsuario(1);
        usuario1.setName("Usuario 1");

        when(usuarioRepo.findAll()).thenReturn(Arrays.asList(usuario1));

        List<usuariosModelo> usuarios = UiService.obtenerUsuarios();
        assertEquals(1, usuarios.size());
        assertEquals("Usuario 1", usuarios.get(0).getName());
    }

    @Test
    void obtenerUsuarioPorId() {
        usuariosModelo usuario = new usuariosModelo();
        usuario.setIdUsuario(1);
        when(usuarioRepo.findById(1L)).thenReturn(Optional.of(usuario));

        Optional<usuariosModelo> found = usuarioService.obtenerUsuarioPorId(1L);
        assertTrue(found.isPresent());
        assertEquals(1, found.get().getIdUsuario());
    }

    @Test
    void crearUsuario() {
        usuariosModelo usuario = new usuariosModelo();
        usuario.setName("Nuevo Usuario");
        when(usuarioRepo.save(usuario)).thenReturn(usuario);

        usuariosModelo created = usuarioService.crearUsuario(usuario);
        assertEquals("Nuevo Usuario", created.getName());
    }

    @Test
    void actualizarUsuario() {
        usuariosModelo usuario = new usuariosModelo();
        usuario.setIdUsuario(1);
        usuario.setName("Usuario Actualizado");

        when(usuarioRepo.existsById(1)).thenReturn(true);
        when(usuarioRepo.save(usuario)).thenReturn(usuario);

        Optional<usuariosModelo> updated = usuarioService.actualizarUsuario(1, usuario);
        assertTrue(updated.isPresent());
        assertEquals("Usuario Actualizado", updated.get().getName());
    }

    @Test
    void eliminarUsuario() {
        doNothing().when(usuarioRepo).deleteById(1L);
        usuarioService.eliminarUsuario(1L);
        verify(usuarioRepo, times(1)).deleteById(1L);
    }
}