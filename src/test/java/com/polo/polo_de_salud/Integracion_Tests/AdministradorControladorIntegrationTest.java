package com.polo.polo_de_salud.Integracion_Tests;
import com.polo.polo_de_salud.ProyectoPoloDeSaludApplication;
import com.polo.polo_de_salud.modelo.administradorModelo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ProyectoPoloDeSaludApplication.class)
public class AdministradorControladorIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @SuppressWarnings("deprecation")
	@Test
    public void testCrearAdministrador() {
        administradorModelo admin = new administradorModelo();
        admin.setUsername("admin");
        admin.setPassword("password");

        ResponseEntity<administradorModelo> response = restTemplate.postForEntity("/api/administradores", admin, administradorModelo.class);
        assertEquals(201, response.getStatusCodeValue());
        assertEquals("admin", Objects.requireNonNull(response.getBody()).getUsername());
    }
}