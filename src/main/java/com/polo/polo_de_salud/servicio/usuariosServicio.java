package com.polo.polo_de_salud.servicio;

import com.polo.polo_de_salud.modelo.usuariosModelo;
import com.polo.polo_de_salud.repositorio.usuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class usuariosServicio {

    private usuarioRepositorio usuarioRepo;

    @Autowired
    public void UsuariosServicio(usuarioRepositorio usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    public usuariosServicio(usuarioRepositorio usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    public List<usuariosModelo> obtenerUsuarios() {
        return usuarioRepo.findAll();
    }

    public Optional<usuariosModelo> obtenerUsuarioPorId(Integer id) {
        return usuarioRepo.findById(id);
    }

    public usuariosModelo crearUsuario(usuariosModelo usuario) {
        return usuarioRepo.save(usuario);
    }

    public Optional<usuariosModelo> actualizarUsuario(Integer id, usuariosModelo usuario) {
        if (usuarioRepo.existsById(id)) {
            usuario.setIdUsuario(id);
            return Optional.of(usuarioRepo.save(usuario));
        }
        return Optional.empty();
    }

    public void eliminarUsuario(Integer id) {
        if (usuarioRepo.existsById(id)) {
            usuarioRepo.deleteById(Long.valueOf(id));
        }
    }
}