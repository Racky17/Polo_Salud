package com.polo.polo_de_salud.servicio;

import com.polo.polo_de_salud.modelo.usuariosModelo;
import com.polo.polo_de_salud.repositorio.usuarioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class usuariosServicio {

    @Autowired
    private usuarioRepositorio usuarioRepo;

    @SuppressWarnings("rawtypes")
	public List<usuariosModelo> obtenerUsuarios() {
        return usuarioRepo.findAll();
    }

    @SuppressWarnings("rawtypes")
	public Optional<usuariosModelo> obtenerUsuarioPorId(Long id) {
        return usuarioRepo.findById(id);
    }

    public usuariosModelo<?> crearUsuario(usuariosModelo<?> usuario) {
        return usuarioRepo.save(usuario);
    }

    @SuppressWarnings("rawtypes")
	public Optional<usuariosModelo> actualizarUsuario(Integer id, usuariosModelo usuario) {
        if (usuarioRepo.existsById(id)) {
            usuario.setIdUsuario(id);
            return Optional.of(usuarioRepo.save(usuario));
        }
        return Optional.empty();
    }

    public void eliminarUsuario (Long id) {
        usuarioRepo.deleteById(id);
    }
}