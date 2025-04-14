package com.example.evaluable.dtos;

public class JugadorDTO {
    private String nombre;
    private String position;
    private long valorMercado;
    private int goles;
    private String nacionalidad;
    private String nombreEquipo;


    public JugadorDTO() {
    }

    public JugadorDTO(String nombre, String position, long valorMercado, int goles, String nacionalidad, String nombreEquipo) {
        this.nombre = nombre;
        this.position = position;
        this.valorMercado = valorMercado;
        this.goles = goles;
        this.nacionalidad = nacionalidad;
        this.nombreEquipo = nombreEquipo;
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

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
}
