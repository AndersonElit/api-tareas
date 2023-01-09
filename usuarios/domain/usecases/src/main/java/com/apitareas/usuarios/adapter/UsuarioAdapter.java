package com.apitareas.usuarios.adapter;

import com.apitareas.usuarios.gateway.UsuarioRepository;
import com.apitareas.usuarios.model.Usuario;
import com.apitareas.usuarios.port.UsuarioPort;
import com.apitareas.usuarios.request.UsuarioRequest;
import com.apitareas.usuarios.response.UsuarioResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
public class UsuarioAdapter implements UsuarioPort {

    private final UsuarioRepository repository;

    @Override
    public void guardarUsuario(UsuarioRequest request) {
        this.repository.guardarUsuario(
                Usuario.builder()
                        .cedula(request.getCedula())
                        .nombre(request.getNombre())
                        .fechaCreacion(LocalDate.now())
                        .build()
        );
    }

    @Override
    public List<UsuarioResponse> listaUsuarios() {
        return repository.listaUsuarios().stream()
                .map(usuario -> UsuarioResponse.builder()
                        .id(usuario.getId())
                        .nombre(usuario.getNombre())
                        .cedula(usuario.getCedula())
                        .fechaCreacion(usuario.getFechaCreacion())
                        .build()).toList();
    }

    @Override
    public UsuarioResponse buscarUsuario(Integer id) {
        Usuario usuario = repository.buscarUsuario(id);
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .nombre(usuario.getNombre())
                .cedula(usuario.getCedula())
                .fechaCreacion(usuario.getFechaCreacion())
                .build();
    }

    @Override
    public Boolean usuarioExiste(Integer id) {
        return repository.usuarioExiste(id);
    }

}
