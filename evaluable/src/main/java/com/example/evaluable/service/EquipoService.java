package com.example.evaluable.service;


import com.example.evaluable.dtos.EquipoCreateDTO;
import com.example.evaluable.dtos.EquipoDTO;
import com.example.evaluable.model.Equipo;

import java.util.List;

public interface EquipoService {
    List<EquipoDTO> getAllTeams();
    EquipoDTO getTeamById(int id);
    List<EquipoDTO> getTeamByName(String nombre);
    EquipoDTO addTeam(EquipoCreateDTO team);
    void deleteTeam(int id);
    EquipoDTO updateTeam(int id, EquipoCreateDTO  equipoDTO);
}
