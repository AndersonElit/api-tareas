package com.apitareas.usuarios.adapters;

import com.apitareas.usuarios.dao.UsuarioDao;
import com.apitareas.usuarios.entities.UsuarioEntity;
import com.apitareas.usuarios.gateway.UsuarioRepository;
import com.apitareas.usuarios.mapper.Mapper;
import com.apitareas.usuarios.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class H2UsuarioAdapter implements UsuarioRepository {

    public final UsuarioDao dao;

    @Override
    public void guardarUsuario(Usuario usuario) {
        this.dao.save(Mapper.map(usuario, UsuarioEntity.class));
    }

    @Override
    public List<Usuario> listaUsuarios() {
        return Mapper.mapAll(dao.findAll(), Usuario.class);
    }

    @Override
    public Usuario buscarUsuario(Integer id) {
        return Mapper.map(dao.findById(id).orElse(new UsuarioEntity()), Usuario.class);
    }

    @Override
    public Boolean usuarioExiste(Integer id) {
        return dao.existsById(id);
    }

}
