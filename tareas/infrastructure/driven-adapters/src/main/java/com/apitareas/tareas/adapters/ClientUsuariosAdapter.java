package com.apitareas.tareas.adapters;

import com.apitareas.tareas.clients.UsuariosClient;
import com.apitareas.tareas.gateways.UsuariosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientUsuariosAdapter implements UsuariosRepository {

    private final UsuariosClient client;

    @Override
    public Boolean usuarioExiste(Integer id) {
        return client.usuarioExiste(id).getBody();
    }
}
