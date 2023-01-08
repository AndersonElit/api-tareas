package com.apitareas.tareas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import java.util.Set;
import java.util.HashSet;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tareas")
public class TareaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "tarea")
    private String tarea;

    @OneToMany(mappedBy = "id.tarea")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<UsuarioTareasEntity> usuarioTareas = new HashSet<>();

}
