package com.example.evaluable.dtos;

import com.example.evaluable.model.Equipo;
import com.example.evaluable.model.Liga;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LigaDTO {
    private String nombreLiga;
    private String fechaInicio;
    private String fechaFin;
    private List<String> nombresEquipos;

    public LigaDTO() {
    }

    public LigaDTO(String nombreLiga, String fechaInicio, String fechaFin) {
        this.nombreLiga = nombreLiga;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nombresEquipos = new ArrayList<>();
    }

    public LigaDTO(String nombreLiga, String fechaInicio, String fechaFin, List<String> nombresEquipos) {
        this.nombreLiga = nombreLiga;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nombresEquipos = nombresEquipos;
    }

    public String getNombreLiga() {
        return nombreLiga;
    }

    public void setNombreLiga(String nombreLiga) {
        this.nombreLiga = nombreLiga;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<String> getNombresEquipos() {
        return nombresEquipos;
    }

    public void setNombresEquipos(List<String> nombresEquipos) {
        this.nombresEquipos = nombresEquipos;
    }
}
