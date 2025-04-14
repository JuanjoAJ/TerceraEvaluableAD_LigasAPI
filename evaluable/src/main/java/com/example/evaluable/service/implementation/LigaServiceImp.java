package com.example.evaluable.service.implementation;

import com.example.evaluable.dtos.LigaDTO;
import com.example.evaluable.mappers.LigaMapper;
import com.example.evaluable.model.Liga;
import com.example.evaluable.repository.LigaRepository;
import com.example.evaluable.service.LigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LigaServiceImp implements LigaService {

    @Autowired
    private LigaRepository ligaRepository;

    @Override
    public List<LigaDTO> getAllLeague() {
        return ligaRepository.findAll().stream()
                .map(LigaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LigaDTO getLeagueById(int id) {
        return ligaRepository.findById(id)
                .map(LigaMapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<LigaDTO> getLeagueByName(String nombre) {
        return ligaRepository.findByNombreLigaContainingIgnoreCase(nombre).stream()
                .map(LigaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LigaDTO addLeague(LigaDTO ligaDTO) {
        Liga liga = LigaMapper.toEntity(ligaDTO);
        Liga savedLiga = ligaRepository.save(liga);
        return LigaMapper.toDTO(savedLiga);
    }

    @Override
    public LigaDTO updateLiga(int id, LigaDTO ligaDTO) {
        Optional<Liga> optionalLiga = ligaRepository.findById(id);
        if (optionalLiga.isPresent()) {
            Liga liga = optionalLiga.get();
            // Actualizar los campos de la entidad con los datos del DTO
            liga.setNombreLiga(ligaDTO.getNombreLiga());
            liga.setFechaInicio(ligaDTO.getFechaInicio());
            liga.setFechaFin(ligaDTO.getFechaFin());
            Liga updatedLiga = ligaRepository.save(liga);
            return LigaMapper.toDTO(updatedLiga);
        }
        return null;
    }

    @Override
    public void deleteLeague(int id) {
        ligaRepository.deleteById(id);
    }
}
