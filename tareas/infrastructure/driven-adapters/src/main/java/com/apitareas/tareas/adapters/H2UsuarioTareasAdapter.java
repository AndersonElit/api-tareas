package com.apitareas.tareas.adapters;

import com.apitareas.tareas.dao.UsuarioTareasDao;
import com.apitareas.tareas.entities.UsuarioTareasEntity;
import com.apitareas.tareas.gateways.UsuarioTareasRepository;
import com.apitareas.tareas.model.UsuarioTareas;
import com.apitareas.usuarios.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class H2UsuarioTareasAdapter implements UsuarioTareasRepository {

    private final UsuarioTareasDao dao;

    @Override
    public void guardarTarea(UsuarioTareas usuarioTareas) {
        this.dao.saveAndFlush(Mapper.map(usuarioTareas, UsuarioTareasEntity.class));
    }

}
