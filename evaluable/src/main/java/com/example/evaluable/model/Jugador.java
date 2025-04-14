package com.example.evaluable.model;

import jakarta.persistence.*;

import java.io.Serializable;


@NamedQuery(name = "Jugador.findAll", query = "FROM Jugador")
@Entity
@Table(name = "jugadores")
public class Jugador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column(name = "posicion")
    private String position;
    @Column(name = "valor_mercado")
    private long valorMercado;
    @Column
    private int goles;
    @Column
    private String nacionalidad;

    @ManyToOne
    @JoinColumn(name = "id_equipo", nullable = true)
    private Equipo equipo;

    public Jugador(String nombre, long valorMercado, String position, int goles, String nacionalidad) {
        this.nombre = nombre;
        this.valorMercado = valorMercado;
        this.position = position;
        this.goles = goles;
        this.nacionalidad = nacionalidad;
    }

    public Jugador(String nombre, String position, long valorMercado, int goles, String nacionalidad, Equipo equipo) {
        this.nombre = nombre;
        this.position = position;
        this.valorMercado = valorMercado;
        this.goles = goles;
        this.nacionalidad = nacionalidad;
        this.equipo = equipo;
    }

    public Jugador() {
    }

    public Jugador(int id, String nombre, String position, long valorMercado, int goles, String nacionalidad, Equipo equipo) {
        this.id = id;
        this.nombre = nombre;
        this.position = position;
        this.valorMercado = valorMercado;
        this.goles = goles;
        this.nacionalidad = nacionalidad;
        this.equipo = equipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getValorMercado() {
        return valorMercado;
    }

    public void setValorMercado(long valorMercado) {
        this.valorMercado = valorMercado;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
