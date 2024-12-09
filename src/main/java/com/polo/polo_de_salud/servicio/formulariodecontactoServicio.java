package com.polo.polo_de_salud.servicio;
import com.polo.polo_de_salud.modelo.formulariodecontactoModelo;
import com.polo.polo_de_salud.repositorio.formulariodecontactoRepositorio;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import java.util.List; 
import java.util.Optional;

@Service 
public class formulariodecontactoServicio {
	@Autowired
	private formulariodecontactoRepositorio formularioRepo;

	public List<formulariodecontactoModelo> obtenerFormularios() {
	    return formularioRepo.findAll();
	}

	public Optional<formulariodecontactoModelo> obtenerFormularioPorId(Long id) {
	    return formularioRepo.findById(id);
	}

	public formulariodecontactoModelo crearFormulario(formulariodecontactoModelo formulario) {
	    return formularioRepo.save(formulario);
	}

	public Optional<formulariodecontactoModelo> actualizarFormulario(Long id, formulariodecontactoModelo formulario) {
	    if (formularioRepo.existsById(id)) {
	        formulario.setId(id);
	        return Optional.of(formularioRepo.save(formulario));
	    }
	    return Optional.empty();
	}

	public void eliminarFormulario(Long id) {
	    formularioRepo.deleteById(id);
	}
}
