package com.example.evaluable.service.implementation;

import com.example.evaluable.dtos.JugadorCreateDTO;
import com.example.evaluable.dtos.JugadorDTO;
import com.example.evaluable.mappers.JugadorMapper;
import com.example.evaluable.model.Equipo;
import com.example.evaluable.model.Jugador;
import com.example.evaluable.repository.EquipoRepository;
import com.example.evaluable.repository.JugadorRepository;
import com.example.evaluable.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JugadorServiceImp implements JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private EquipoRepository equipoRepository;

    @Override
    public List<JugadorDTO> getAllPlayers() {
        return jugadorRepository.findAll().stream().map(JugadorMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public JugadorDTO getPlayerById(int id) {
        return jugadorRepository.findById(id)
                .map(JugadorMapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<JugadorDTO> getPlayerByName(String nombre) {
        return jugadorRepository.findByNombreContainingIgnoreCase(nombre)
                .stream()
                .map(JugadorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public JugadorDTO addPlayer(JugadorCreateDTO player) {
        Jugador jugador = JugadorMapper.toEntity(player);
        if (player.getIdEquipo() != null) {
            Optional<Equipo> optionalLiga = equipoRepository.findById(player.getIdEquipo());
            optionalLiga.ifPresent(jugador::setEquipo);
        }
        Jugador savedPlayer = jugadorRepository.save(jugador);
        return JugadorMapper.toDTO(savedPlayer);
    }


    @Override
    public JugadorDTO updatePlayer(int id, JugadorCreateDTO jugadorDTO) {
        Optional<Jugador> optionalJugador = jugadorRepository.findById(id);
        if (optionalJugador.isPresent()) {
            Jugador jugador = optionalJugador.get();

            // Actualizamos campos básicos
            jugador.setNombre(jugadorDTO.getNombre());
            jugador.setPosition(jugadorDTO.getPosition());
            jugador.setValorMercado(jugadorDTO.getValorMercado());
            jugador.setGoles(jugadorDTO.getGoles());
            jugador.setNacionalidad(jugadorDTO.getNacionalidad());

            // Actualizamos el equipo si se envía un idEquipo válido
            if (jugadorDTO.getIdEquipo() != null) {
                Optional<Equipo> optionalEquipo = equipoRepository.findById(jugadorDTO.getIdEquipo());
                if (optionalEquipo.isPresent()) {
                    jugador.setEquipo(optionalEquipo.get());
                } else {
                    jugador.setEquipo(null);
                }
            }

            Jugador updatedJugador = jugadorRepository.save(jugador);
            return JugadorMapper.toDTO(updatedJugador);
        }

        return null;
    }


    @Override
    public void deletePlayer(int id) {
        jugadorRepository.deleteById(id);
    }


}
