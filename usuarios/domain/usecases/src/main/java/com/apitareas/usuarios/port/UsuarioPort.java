package com.apitareas.usuarios.port;

import com.apitareas.usuarios.request.UsuarioRequest;
import com.apitareas.usuarios.response.UsuarioResponse;

import java.util.List;

public interface UsuarioPort {
    void guardarUsuario(UsuarioRequest request);
    List<UsuarioResponse> listaUsuarios();
    UsuarioResponse buscarUsuario(Integer id);
    Boolean usuarioExiste(Integer id);
}
