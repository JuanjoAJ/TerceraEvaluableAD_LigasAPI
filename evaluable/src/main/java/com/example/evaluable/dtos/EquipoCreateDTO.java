package com.example.evaluable.dtos;

public class EquipoCreateDTO {
    private String nombreEquipo;
    private String ciudad;
    private Integer idLiga;

    public EquipoCreateDTO() {
    }

    public EquipoCreateDTO(String nombreEquipo, String ciudad, Integer idLiga) {
        this.nombreEquipo = nombreEquipo;
        this.ciudad = ciudad;
        this.idLiga = idLiga;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getIdLiga() {
        return idLiga;
    }

    public void setIdLiga(Integer idLiga) {
        this.idLiga = idLiga;
    }
}
