package com.example.evaluable.controller;

import com.example.evaluable.dtos.EntrenadorCreateDTO;
import com.example.evaluable.dtos.EntrenadorDTO;
import com.example.evaluable.dtos.JugadorCreateDTO;
import com.example.evaluable.dtos.JugadorDTO;
import com.example.evaluable.service.EntrenadorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Entrenadores", description = "Operaciones relacionadas con entrenadores")
@RestController
@RequestMapping("/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    // GET ALL
    @GetMapping("/all")
    public ResponseEntity<List<EntrenadorDTO>> getAllTrainers() {
        try {
            List<EntrenadorDTO> entrenadores = entrenadorService.getAllTrainers();

            if (entrenadores.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return ResponseEntity.ok(entrenadores);
        } catch (Exception ex) {
            System.out.println("Error al obtener entrenadores: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET POR ID
    @GetMapping("/id/{id}")
    public ResponseEntity<EntrenadorDTO> getTrainerById(@PathVariable int id) {
        try {
            EntrenadorDTO entrenador = entrenadorService.getTrainerById(id);
            if (entrenador == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(entrenador);

        } catch (Exception ex) {
            System.out.println("Error al obtener entrenadores: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET POR NOMBRE
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<EntrenadorDTO>> getTrainerByNombre(@PathVariable String nombre) {
        try {
            List<EntrenadorDTO> entrenadores = entrenadorService.getTrainerByName(nombre);

            if (entrenadores.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return ResponseEntity.ok(entrenadores);
        } catch (Exception ex) {
            System.out.println("Error al obtener entrenadores: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //CREATE ENTRENADOR
    @PostMapping
    public ResponseEntity<EntrenadorDTO> createTrainer(@RequestBody EntrenadorCreateDTO entrenadorCreateDTO) {
        try {
            EntrenadorDTO dto =  entrenadorService.addTrainer(entrenadorCreateDTO);
            if (dto != null) {
                return new ResponseEntity<>(dto, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            System.out.println("Error al crear entrenador: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //ACTUALIZAR ENTRENGADOR
    @PutMapping("/{id}")
    public ResponseEntity<EntrenadorDTO> updateTrainer(@PathVariable int id, @RequestBody EntrenadorCreateDTO entrenadorCreateDTO) {
        try {
            EntrenadorDTO dto = entrenadorService.updateTrainer(id, entrenadorCreateDTO);
            if (dto != null) {
                return ResponseEntity.ok(dto);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            System.out.println("Error al actualizar entrenador: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // BORRAR ENTRENADOR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrainer(@PathVariable int id) {
        try {
            entrenadorService.deleteTrainer(id);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            System.out.println("Error al eliminar entrenador: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


