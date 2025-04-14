package com.example.evaluable.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;


@NamedQuery(name = "Equipo.findAll", query = "From Equipo")
@Entity
@Table(name = "equipos")
public class Equipo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre_equipo")
    private String nombreEquipo;
    @Column
    private String ciudad;

    @OneToOne(mappedBy = "equipo", cascade = CascadeType.REMOVE)
    private Entrenador entrenador;

    @OneToMany(mappedBy = "equipo", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Jugador> jugadores;

    @ManyToOne
    @JoinColumn(name = "id_liga", nullable = true)
    private Liga liga;


    public Equipo(String nombreEquipo, String ciudad) {
        this.nombreEquipo = nombreEquipo;
        this.ciudad = ciudad;
    }

    public Equipo(int id, String nombreEquipo, String ciudad) {
        this.id = id;
        this.nombreEquipo = nombreEquipo;
        this.ciudad = ciudad;
    }


    public Equipo() {
    }

    public Equipo(String nombreEquipo, int id, String ciudad, Entrenador entrenador, List<Jugador> jugadores, Liga liga) {
        this.nombreEquipo = nombreEquipo;
        this.id = id;
        this.ciudad = ciudad;
        this.entrenador = entrenador;
        this.jugadores = jugadores;
        this.liga = liga;
    }

    public Liga getLiga() {
        return liga;
    }

    public void setLiga(Liga liga) {
        this.liga = liga;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nombreEquipo;
    }
}
