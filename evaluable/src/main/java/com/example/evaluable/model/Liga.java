package com.example.evaluable.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@NamedQuery(name = "Liga.findAll", query = "FROM Liga")
@Entity
@Table(name = "ligas")
public class Liga implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre_liga")
    private String nombreLiga;
    @Column(name = "fecha_inicio")
    private String fechaInicio;
    @Column(name = "fecha_fin")
    private String fechaFin;

    @OneToMany(mappedBy = "liga", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Equipo> equipos;

    public Liga(String nombreLiga, String fechaInicio, String fechaFin) {
        this.nombreLiga = nombreLiga;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Liga(int id, String nombreLiga, String fechaInicio, String fechaFin) {
        this.id = id;
        this.nombreLiga = nombreLiga;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Liga() {
    }

    public Liga(int id, String nombreLiga, String fechaInicio, String fechaFin, List<Equipo> equipos) {
        this.id = id;
        this.nombreLiga = nombreLiga;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.equipos = equipos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    @Override
    public String toString() {
        return nombreLiga;
    }
}
