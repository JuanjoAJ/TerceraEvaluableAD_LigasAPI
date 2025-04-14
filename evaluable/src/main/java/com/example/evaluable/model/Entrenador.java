package com.example.evaluable.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;


import java.io.Serializable;

@Entity
@Table(name = "entrenadores")
@NamedQuery(name = "Entrenador.findAll", query = "FROM Entrenador")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "nombre")
public class Entrenador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private double calificacion;
    @Column
    private int titulos;

    @OneToOne
    @JoinColumn(name = "id_equipo", nullable = true)
    private Equipo equipo;


    public Entrenador() {
    }

    public Entrenador(Equipo equipo, int titulos, double calificacion, String nombre, int id) {
        this.equipo = equipo;
        this.titulos = titulos;
        this.calificacion = calificacion;
        this.nombre = nombre;
        this.id = id;
    }

    public Entrenador(String nombre, double calificacion, int titulos) {
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.titulos = titulos;
    }

    public Entrenador(String nombre, double calificacion, int titulos, Equipo equipo) {
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.titulos = titulos;
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

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public int getTitulos() {
        return titulos;
    }

    public void setTitulos(int titulos) {
        this.titulos = titulos;
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
