package com.example.evaluable.dtos;

public class JugadorCreateDTO {


    private String nombre;
    private String position;
    private long valorMercado;
    private int goles;
    private String nacionalidad;
    private Integer idEquipo;


    public JugadorCreateDTO() {
    }

    public JugadorCreateDTO(String nombre, String position, long valorMercado, int goles, String nacionalidad, int idEquipo) {
        this.nombre = nombre;
        this.position = position;
        this.valorMercado = valorMercado;
        this.goles = goles;
        this.nacionalidad = nacionalidad;
        this.idEquipo = idEquipo;
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

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }
}
