package com.apitareas.tareas.dao;

import com.apitareas.tareas.entities.UsuarioTareasEntity;
import com.apitareas.tareas.entities.UsuarioTareasIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioTareasDao extends JpaRepository<UsuarioTareasEntity, UsuarioTareasIdEntity> {
}
