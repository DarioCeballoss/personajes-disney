package com.alkemy.disney.disney.entity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name="personaje")
@Getter
@Setter

public class PersonajeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String imagen;
    private String nombre;
    private Long edad;
    private Long peso;
    private String historia;
    //peliculas asociadas

}
