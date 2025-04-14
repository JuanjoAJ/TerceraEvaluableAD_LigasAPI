package com.example.evaluable.service;

import com.example.evaluable.dtos.EntrenadorCreateDTO;
import com.example.evaluable.dtos.EntrenadorDTO;
import com.example.evaluable.model.Entrenador;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EntrenadorService {

    List<EntrenadorDTO> getAllTrainers();

    EntrenadorDTO getTrainerById(int id);

    List<EntrenadorDTO> getTrainerByName(String nombre);

    EntrenadorDTO addTrainer(EntrenadorCreateDTO trainer);

    EntrenadorDTO updateTrainer(int id, EntrenadorCreateDTO trainerDTO);

    void deleteTrainer(int id);

}
