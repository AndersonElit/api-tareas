package com.apitareas.usuarios.gateway;

import com.apitareas.usuarios.model.Usuario;
import com.apitareas.usuarios.request.UsuarioRequest;

import java.util.List;

public interface UsuarioRepository {
    void guardarUsuario(Usuario usuario);
    List<Usuario> listaUsuarios();
    Usuario buscarUsuario(Integer id);
    Boolean usuarioExiste(Integer id);
}
