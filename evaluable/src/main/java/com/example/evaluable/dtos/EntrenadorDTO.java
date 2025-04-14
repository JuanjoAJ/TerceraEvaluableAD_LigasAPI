package com.example.evaluable.dtos;

import com.example.evaluable.model.Entrenador;

public class EntrenadorDTO {

    private String nombre;
    private double calificacion;
    private int titulos;
    private String nombreEquipo;

    public EntrenadorDTO() {
    }

    public EntrenadorDTO(String nombre, double calificacion, int titulos, String nombreEquipo) {
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.titulos = titulos;
        this.nombreEquipo = nombreEquipo;
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

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
}
