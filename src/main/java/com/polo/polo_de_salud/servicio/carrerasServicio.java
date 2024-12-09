package com.polo.polo_de_salud.servicio;

import com.polo.polo_de_salud.modelo.carrerasModelo;
import com.polo.polo_de_salud.repositorio.carrerasRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class carrerasServicio {

    @Autowired
    private carrerasRepositorio carrerasRepo;

    @SuppressWarnings("rawtypes")
	public List<carrerasModelo> obtenerCarreras() {
        return carrerasRepo.findAll();
    }

    @SuppressWarnings("rawtypes")
	public Optional<carrerasModelo> obtenerCarreraPorId(Long id) {
        return carrerasRepo.findById(id);
    }

    public carrerasModelo<?> crearCarrera(carrerasModelo<?> carrera) {
        return carrerasRepo.save(carrera);
    }

    @SuppressWarnings("rawtypes")
	public Optional<carrerasModelo> actualizarCarrera(Long id, carrerasModelo carrera) {
        if (carrerasRepo.existsById(id)) {
            carrera.setIdCarrera(id);
            return Optional.of(carrerasRepo.save(carrera));
        }
        return Optional.empty();
    }

    public void eliminarCarrera(Long id) {
        carrerasRepo.deleteById(id);
    }
}