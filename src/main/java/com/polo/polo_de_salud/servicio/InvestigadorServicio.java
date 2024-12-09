package com.polo.polo_de_salud.servicio;

import com.polo.polo_de_salud.modelo.investigadorModelo;
import com.polo.polo_de_salud.repositorio.investigadorRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestigadorServicio {

    @Autowired
    private investigadorRepositorio investigadorRepo;

    public List<investigadorModelo> obtenerInvestigadores() {
        return investigadorRepo.findAll();
    }

    public Optional<investigadorModelo> obtenerInvestigadorPorId(Long id) {
        return investigadorRepo.findById(id);
    }

    public investigadorModelo crearInvestigador(investigadorModelo investigador) {
        return investigadorRepo.save(investigador);
    }

    public Optional<investigadorModelo> actualizarInvestigador(Long id, investigadorModelo investigador) {
        if (investigadorRepo.existsById(id)) {
            investigador.setId(id);
            return Optional.of(investigadorRepo.save(investigador));
        }
        return Optional.empty();
    }

    public void eliminarInvestigador(Long id) {
        investigadorRepo.deleteById(id);
    }
}