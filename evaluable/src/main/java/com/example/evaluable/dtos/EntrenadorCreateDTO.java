package com.example.evaluable.dtos;

public class EntrenadorCreateDTO {

    private String nombre;
    private double calificacion;
    private int titulos;
    private Integer idEquipo;

    public EntrenadorCreateDTO() {
    }

    public EntrenadorCreateDTO(String nombre, double calificacion, int titulos, int idEquipo) {
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.titulos = titulos;
        this.idEquipo = idEquipo;
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

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }
}
