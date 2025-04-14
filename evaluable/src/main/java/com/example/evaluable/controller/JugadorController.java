package com.example.evaluable.controller;

import com.example.evaluable.dtos.JugadorCreateDTO;
import com.example.evaluable.dtos.JugadorDTO;
import com.example.evaluable.service.JugadorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Jugadores", description = "Operaciones relacionadas con jugadores")
@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    // GET ALL
    @GetMapping("/all")
    public ResponseEntity<List<JugadorDTO>> getAllPlayers() {
        try {
            List<JugadorDTO> jugadores = jugadorService.getAllPlayers();
            if (jugadores.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(jugadores);
        } catch (Exception ex) {
            System.out.println("Error al obtener jugadores: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET POR ID
    @GetMapping("/id/{id}")
    public ResponseEntity<JugadorDTO> getPlayerById(@PathVariable int id) {
        try {
            JugadorDTO jugador = jugadorService.getPlayerById(id);
            if (jugador == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(jugador);
        } catch (Exception ex) {
            System.out.println("Error al obtener jugador por id: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET POR NOMBRE
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<JugadorDTO>> getPlayersByName(@PathVariable String nombre) {
        try {
            List<JugadorDTO> jugadores = jugadorService.getPlayerByName(nombre);
            if (jugadores.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(jugadores);
        } catch (Exception ex) {
            System.out.println("Error al obtener jugadores por nombre: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // CREATE JUGADOR
    @PostMapping
    public ResponseEntity<JugadorDTO> createPlayer(@RequestBody JugadorCreateDTO jugadorCreateDTO) {
        try {
            JugadorDTO jugadorDTO = jugadorService.addPlayer(jugadorCreateDTO);
            if (jugadorDTO != null) {
                return new ResponseEntity<>(jugadorDTO, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            System.out.println("Error al crear jugador: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ACTUALIZAR JUGADOR
    @PutMapping("/{id}")
    public ResponseEntity<JugadorDTO> updatePlayer(@PathVariable int id, @RequestBody JugadorCreateDTO jugadorCreateDTO) {
        try {
            JugadorDTO jugadorDTO = jugadorService.updatePlayer(id, jugadorCreateDTO);
            if (jugadorDTO != null) {
                return ResponseEntity.ok(jugadorDTO);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            System.out.println("Error al actualizar jugador: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ELIMINAR JUGADOR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable int id) {
        try {
            jugadorService.deletePlayer(id);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            System.out.println("Error al eliminar jugador: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


