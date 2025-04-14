package com.example.evaluable.mappers;

import com.example.evaluable.dtos.EquipoCreateDTO;
import com.example.evaluable.dtos.EquipoDTO;
import com.example.evaluable.model.Equipo;
import com.example.evaluable.model.Jugador;
import com.example.evaluable.model.Liga;

import java.util.stream.Collectors;

public class EquipoMapper {
    public static EquipoDTO toDTO(Equipo equipo) {
        EquipoDTO dto = new EquipoDTO();
        dto.setNombreEquipo(equipo.getNombreEquipo());
        dto.setCiudad(equipo.getCiudad());
        dto.setNombreEntrenador(equipo.getEntrenador() != null ? equipo.getEntrenador().getNombre() : null);
        dto.setNombreLiga(equipo.getLiga() != null ? equipo.getLiga().getNombreLiga() : null);

        if (equipo.getJugadores() != null) {
            dto.setNombresJugadores(
                    equipo.getJugadores().stream()
                            .map(Jugador::getNombre)
                            .collect(Collectors.toList())
            );
        }
        return dto;
    }

    public static Equipo toEntity(EquipoCreateDTO dto) {
        Equipo equipo = new Equipo();
        equipo.setNombreEquipo(dto.getNombreEquipo());
        equipo.setCiudad(dto.getCiudad());
        if (dto.getIdLiga() != null) {
            Liga liga = new Liga();
            liga.setId(dto.getIdLiga());
            equipo.setLiga(liga);
        }
        return equipo;
    }

}
