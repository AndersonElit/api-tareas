package com.apitareas.usuarios.service;

import com.apitareas.usuarios.port.UsuarioPort;
import com.apitareas.usuarios.request.UsuarioRequest;
import com.apitareas.usuarios.response.UsuarioResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioPort port;

    public void guardarUsuario(UsuarioRequest request) {
        this.port.guardarUsuario(request);
    }

    public List<UsuarioResponse> listaUsuarios() {
        return port.listaUsuarios();
    }

    public UsuarioResponse buscarUsuario(Integer id) {
        return port.buscarUsuario(id);
    }

    public Boolean usuarioExiste(Integer id) {
        return port.usuarioExiste(id);
    }

}
