package com.example.evaluable.mappers;

import com.example.evaluable.dtos.EntrenadorCreateDTO;
import com.example.evaluable.dtos.EntrenadorDTO;
import com.example.evaluable.model.Entrenador;
import com.example.evaluable.model.Equipo;

public class EntrenadorMapper {

    public static EntrenadorDTO toDTO(Entrenador entrenador) {
        EntrenadorDTO dto = new EntrenadorDTO();
        dto.setNombre(entrenador.getNombre());
        dto.setCalificacion(entrenador.getCalificacion());
        dto.setTitulos(entrenador.getTitulos());
        dto.setNombreEquipo(entrenador.getEquipo() != null ? entrenador.getEquipo().getNombreEquipo() : null);
        return dto;
    }

    public static Entrenador toEntity(EntrenadorCreateDTO dto) {
        Entrenador entrenador = new Entrenador();
        entrenador.setNombre(dto.getNombre());
        entrenador.setCalificacion(dto.getCalificacion());
        entrenador.setTitulos(dto.getTitulos());

        if (dto.getIdEquipo() != null) {
            Equipo equipo = new Equipo();
            equipo.setId(dto.getIdEquipo());
            entrenador.setEquipo(equipo);
        }

        return entrenador;
    }
}
