package com.polo.polo_de_salud.servicio;

import com.polo.polo_de_salud.modelo.categoriaModelo;
import com.polo.polo_de_salud.repositorio.categoriaRepositorio;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class categoriaServicioTest {

    @InjectMocks
    private categoriaServicio categoriaService;

    @Mock
    private categoriaRepositorio categoriaRepo;

    public categoriaServicioTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obtenerCategorias() {
        categoriaModelo categoria1 = new categoriaModelo();
        categoria1.setId(1L);

        when(categoriaRepo.findAll()).thenReturn(Arrays.asList(categoria1));

        List<categoriaModelo> categorias = categoriaService.obtenerCategorias();
        assertEquals(1, categorias.size());
    }

    @Test
    void obtenerCategoriaPorId() {
        categoriaModelo categoria = new ```java
        categoriaModelo();
        categoria.setId(1L);
        when(categoriaRepo.findById(1L)).thenReturn(Optional.of(categoria));

        Optional<categoriaModelo> found = categoriaService.obtenerCategoriaPorId(1L);
        assertTrue(found.isPresent());
        assertEquals(1L, found.get().getId());
    }

    @Test
    void crearCategoria() {
        categoriaModelo categoria = new categoriaModelo();
        when(categoriaRepo.save(categoria)).thenReturn(categoria);

        categoriaModelo created = categoriaService.crearCategoria(categoria);
        assertNotNull(created);
    }

    @Test
    void actualizarCategoria() {
        categoriaModelo categoria = new categoriaModelo();
        categoria.setId(1L);

        when(categoriaRepo.existsById(1L)).thenReturn(true);
        when(categoriaRepo.save(categoria)).thenReturn(categoria);

        Optional<categoriaModelo> updated = categoriaService.actualizarCategoria(1L, categoria);
        assertTrue(updated.isPresent());
    }

    @Test
    void eliminarCategoria() {
        doNothing().when(categoriaRepo).deleteById(1L);
        categoriaService.eliminarCategoria(1L);
        verify(categoriaRepo, times(1)).deleteById(1L);
    }
}