package com.example.evaluable.service;

import com.example.evaluable.dtos.LigaDTO;
import com.example.evaluable.model.Liga;

import java.util.List;

public interface LigaService {
    List<LigaDTO> getAllLeague();

    LigaDTO getLeagueById(int id);

    List<LigaDTO> getLeagueByName(String nombre);

    LigaDTO addLeague(LigaDTO league);

    void deleteLeague(int id);

    LigaDTO updateLiga(int id, LigaDTO ligaDTO);
}
