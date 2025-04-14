package com.example.evaluable.service.implementation;

import com.example.evaluable.dtos.EntrenadorCreateDTO;
import com.example.evaluable.dtos.EntrenadorDTO;
import com.example.evaluable.mappers.EntrenadorMapper;
import com.example.evaluable.model.Entrenador;
import com.example.evaluable.model.Equipo;
import com.example.evaluable.repository.EntrenadorRepository;
import com.example.evaluable.repository.EquipoRepository;
import com.example.evaluable.service.EntrenadorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntrenadorServiceImp implements EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Autowired
    private EquipoRepository equipoRepository;

    @Override
    public List<EntrenadorDTO> getAllTrainers() {
        List<Entrenador> entrenadores =  entrenadorRepository.findAll();
        if(entrenadores.isEmpty()) return new ArrayList<>();
        return  entrenadores.stream()
                .map(EntrenadorMapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public EntrenadorDTO getTrainerById(int id) {
        return entrenadorRepository.findById(id)
                .map(EntrenadorMapper::toDTO)
                .orElse(null);
    }


    @Override
    public List<EntrenadorDTO> getTrainerByName(String nombre) {
        List<Entrenador> entrenadores = entrenadorRepository.findByNombreContainingIgnoreCase(nombre);
        if(entrenadores.isEmpty()) return new ArrayList<>();
        return  entrenadores.stream()
                .map(EntrenadorMapper::toDTO)
                .collect(Collectors.toList());

    }

    @Override
    public EntrenadorDTO addTrainer(EntrenadorCreateDTO trainer) {
        Entrenador entrenador = EntrenadorMapper.toEntity(trainer);


        if (trainer.getIdEquipo() != null) {
            Optional<Equipo> optionalEquipo = equipoRepository.findById(trainer.getIdEquipo());
            optionalEquipo.ifPresent(entrenador::setEquipo);
        }

        Entrenador savedEntrenador = entrenadorRepository.save(entrenador);
        return EntrenadorMapper.toDTO(savedEntrenador);
    }

    @Override
    public EntrenadorDTO updateTrainer(int id, EntrenadorCreateDTO dto) {
        Optional<Entrenador> optionalEntrenador = entrenadorRepository.findById(id);

        if (optionalEntrenador.isPresent()) {
            Entrenador entrenador = optionalEntrenador.get();

            entrenador.setNombre(dto.getNombre());
            entrenador.setCalificacion(dto.getCalificacion());
            entrenador.setTitulos(dto.getTitulos());

            if (dto.getIdEquipo() != null) {
                Optional<Equipo> optionalEquipo = equipoRepository.findById(dto.getIdEquipo());
                if (optionalEquipo.isPresent()) {
                    entrenador.setEquipo(optionalEquipo.get());
                } else {
                    entrenador.setEquipo(null);
                }
            }
            Entrenador updatedEntrenador = entrenadorRepository.save(entrenador);
            return EntrenadorMapper.toDTO(updatedEntrenador);
        }

        return null;
    }


    @Override
    @Transactional
    public void deleteTrainer(int id) {
        Optional<Entrenador> optionalEntrenador = entrenadorRepository.findById(id);
        if (optionalEntrenador.isPresent()) {
            Entrenador entrenador = optionalEntrenador.get();

            Equipo equipo = entrenador.getEquipo();
            if (equipo != null) {
                equipo.setEntrenador(null);
                equipoRepository.save(equipo);
            }
            entrenadorRepository.delete(entrenador);
        }
    }
}
