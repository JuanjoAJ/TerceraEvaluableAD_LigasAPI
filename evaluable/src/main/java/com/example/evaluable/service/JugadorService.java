package com.example.evaluable.service;

import com.example.evaluable.dtos.JugadorCreateDTO;
import com.example.evaluable.dtos.JugadorDTO;
import com.example.evaluable.model.Entrenador;
import com.example.evaluable.model.Jugador;

import java.util.List;

public interface JugadorService {
    List<JugadorDTO> getAllPlayers();

    JugadorDTO getPlayerById(int id);

    List<JugadorDTO> getPlayerByName(String nombre);

    JugadorDTO addPlayer(JugadorCreateDTO player);

    JugadorDTO updatePlayer(int id, JugadorCreateDTO jugadorDTO);
    void deletePlayer(int id);
}
