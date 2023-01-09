package com.apitareas.tareas.adapters;

import com.apitareas.tareas.dao.TareaDao;
import com.apitareas.tareas.entities.TareaEntity;
import com.apitareas.tareas.gateways.TareaRepository;
import com.apitareas.tareas.model.Tarea;
import com.apitareas.usuarios.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class H2TareaAdapter implements TareaRepository {

    private final TareaDao dao;

    @Override
    public Tarea guardarTarea(Tarea tarea) {
        return Mapper.map(dao.save(Mapper.map(tarea, TareaEntity.class)),
                Tarea.class);
    }

}
