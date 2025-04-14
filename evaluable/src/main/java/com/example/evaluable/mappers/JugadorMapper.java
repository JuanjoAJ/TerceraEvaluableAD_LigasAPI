package com.example.evaluable.mappers;

import com.example.evaluable.dtos.JugadorCreateDTO;
import com.example.evaluable.dtos.JugadorDTO;
import com.example.evaluable.model.Equipo;
import com.example.evaluable.model.Jugador;

public class JugadorMapper {

    public static JugadorDTO toDTO(Jugador jugador) {
        JugadorDTO dto = new JugadorDTO();
        dto.setNombre(jugador.getNombre());
        dto.setPosition(jugador.getPosition());
        dto.setValorMercado(jugador.getValorMercado());
        dto.setGoles(jugador.getGoles());
        dto.setNacionalidad(jugador.getNacionalidad());
        dto.setNombreEquipo(jugador.getEquipo() != null ? jugador.getEquipo().getNombreEquipo() : null);
        return dto;
    }

    public static Jugador toEntity(JugadorCreateDTO dto) {
        Jugador jugador = new Jugador();
        jugador.setNombre(dto.getNombre());
        jugador.setPosition(dto.getPosition());
        jugador.setValorMercado(dto.getValorMercado());
        jugador.setGoles(dto.getGoles());
        jugador.setNacionalidad(dto.getNacionalidad());

        if (dto.getIdEquipo() != null) {
            Equipo equipo = new Equipo();
            equipo.setId(dto.getIdEquipo());
            jugador.setEquipo(equipo);
        }

        return jugador;
    }
}
