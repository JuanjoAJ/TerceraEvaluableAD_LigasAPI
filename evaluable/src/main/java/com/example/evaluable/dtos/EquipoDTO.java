package com.example.evaluable.dtos;

import com.example.evaluable.model.Equipo;
import com.example.evaluable.model.Jugador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EquipoDTO {
    private String nombreEquipo;
    private String ciudad;
    private String nombreEntrenador;
    private String nombreLiga;
    private List<String> nombresJugadores;

    public EquipoDTO() {
    }

    public EquipoDTO(String nombreEquipo, String ciudad, String nombreEntrenador, String nombreLiga) {
        this.nombreEquipo = nombreEquipo;
        this.ciudad = ciudad;
        this.nombreEntrenador = nombreEntrenador;
        this.nombreLiga = nombreLiga;
        nombresJugadores = new ArrayList<>();
    }

    public EquipoDTO(String nombreEquipo, String ciudad, String nombreEntrenador, String nombreLiga, List<String> nombresJugadores) {
        this.nombreEquipo = nombreEquipo;
        this.ciudad = ciudad;
        this.nombreEntrenador = nombreEntrenador;
        this.nombreLiga = nombreLiga;
        this.nombresJugadores = nombresJugadores;
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

    public String getNombreEntrenador() {
        return nombreEntrenador;
    }

    public void setNombreEntrenador(String nombreEntrenador) {
        this.nombreEntrenador = nombreEntrenador;
    }

    public String getNombreLiga() {
        return nombreLiga;
    }

    public void setNombreLiga(String nombreLiga) {
        this.nombreLiga = nombreLiga;
    }

    public List<String> getNombresJugadores() {
        return nombresJugadores;
    }

    public void setNombresJugadores(List<String> nombresJugadores) {
        this.nombresJugadores = nombresJugadores;
    }

}
