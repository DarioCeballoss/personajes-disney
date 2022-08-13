package com.alkemy.disney.disney.entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="pelicula")
@Getter
@Setter

public class PeliculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String imagen;
    private String titulo;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyy/MM/dd")
    private LocalDate fechaCreacion;

    private Long calificacion;
    //genero
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genero_id")
    private GeneroEntity genero;

    @Column(name = "genero_id")
    private Long generoId;

    //personajes asociados
    @ManyToMany (
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable
            (
                    name = "peli_actor",
                    joinColumns = @JoinColumn(name = "peli_id"),
                    inverseJoinColumns = @JoinColumn(name = "actor_id")
            )
    private Set<PersonajeEntity> personajes = new HashSet<>();

}
