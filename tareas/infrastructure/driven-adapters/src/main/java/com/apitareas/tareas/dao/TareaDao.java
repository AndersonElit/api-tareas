package com.apitareas.tareas.dao;

import com.apitareas.tareas.entities.TareaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaDao extends JpaRepository<TareaEntity, Integer> {
}
