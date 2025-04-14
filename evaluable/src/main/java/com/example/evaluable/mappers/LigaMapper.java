package com.example.evaluable.mappers;

import com.example.evaluable.dtos.LigaDTO;
import com.example.evaluable.model.Equipo;
import com.example.evaluable.model.Liga;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class LigaMapper {

    /**
     * Convierte una entidad Liga a un DTO.
     * @param liga La entidad Liga.
     * @return Un objeto LigaDTO con los datos de la entidad.
     */
    public static LigaDTO toDTO(Liga liga) {
        LigaDTO dto = new LigaDTO();
        dto.setNombreLiga(liga.getNombreLiga());
        dto.setFechaInicio(liga.getFechaInicio());
        dto.setFechaFin(liga.getFechaFin());
        if (liga.getEquipos() != null) {
            dto.setNombresEquipos(liga.getEquipos().stream()
                    .map(Equipo::getNombreEquipo)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    /**
     * Convierte un DTO de Liga a una entidad.
     * @param dto El objeto LigaDTO.
     * @return Una entidad Liga con los datos del DTO.
     */
    public static Liga toEntity(LigaDTO dto) {
        Liga liga = new Liga();
        liga.setNombreLiga(dto.getNombreLiga());
        liga.setFechaInicio(dto.getFechaInicio());
        liga.setFechaFin(dto.getFechaFin());
        return liga;
    }
}
