package com.example.evaluable.service.implementation;

import com.example.evaluable.dtos.EquipoCreateDTO;
import com.example.evaluable.dtos.EquipoDTO;
import com.example.evaluable.mappers.EquipoMapper;
import com.example.evaluable.model.Equipo;
import com.example.evaluable.model.Liga;
import com.example.evaluable.repository.EquipoRepository;
import com.example.evaluable.repository.LigaRepository;
import com.example.evaluable.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EquipoServiceImp implements EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private LigaRepository ligaRepository;

    @Override
    public List<EquipoDTO> getAllTeams() {
        return equipoRepository.findAll()
                .stream()
                .map(EquipoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EquipoDTO getTeamById(int id) {
        return equipoRepository.findById(id)
                .map(EquipoMapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<EquipoDTO> getTeamByName(String nombre) {
        return equipoRepository.findByNombreEquipoContainingIgnoreCase(nombre)
                .stream()
                .map(EquipoMapper::toDTO)
                .collect(Collectors.toList());
    }



    @Override
    public void deleteTeam(int id) {

        equipoRepository.deleteById(id);
    }

    @Override
    public EquipoDTO addTeam(EquipoCreateDTO equipoDTO) {
        // Convertimos el DTO a entidad
        Equipo equipo = EquipoMapper.toEntity(equipoDTO);
        // Si se envía idLiga, consultamos la liga real y la asignamos
        if (equipoDTO.getIdLiga() != null) {
            Optional<Liga> optionalLiga = ligaRepository.findById(equipoDTO.getIdLiga());
            optionalLiga.ifPresent(equipo::setLiga);
        }
        Equipo savedEquipo = equipoRepository.save(equipo);
        return EquipoMapper.toDTO(savedEquipo);
    }

    @Override
    public EquipoDTO updateTeam(int id, EquipoCreateDTO equipoDTO) {
        Optional<Equipo> optionalEquipo = equipoRepository.findById(id);
        if (optionalEquipo.isPresent()) {
            Equipo equipo = optionalEquipo.get();
            // Actualizamos los campos básicos
            equipo.setNombreEquipo(equipoDTO.getNombreEquipo());
            equipo.setCiudad(equipoDTO.getCiudad());
            // Actualizamos la liga: consultamos si se envía idLiga y se encuentra una liga existente
            if (equipoDTO.getIdLiga() != null) {
                Optional<Liga> optionalLiga = ligaRepository.findById(equipoDTO.getIdLiga());
                if (optionalLiga.isPresent()) {
                    equipo.setLiga(optionalLiga.get());
                } else {
                    equipo.setLiga(null);
                }
            }
            Equipo updatedEquipo = equipoRepository.save(equipo);
            return EquipoMapper.toDTO(updatedEquipo);
        }
        return null;
    }
}
