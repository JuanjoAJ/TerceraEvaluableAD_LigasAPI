package com.example.evaluable.controller;

import com.example.evaluable.dtos.EquipoCreateDTO;
import com.example.evaluable.dtos.EquipoDTO;
import com.example.evaluable.service.EquipoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Equipos", description = "Todas las operciones relacionadas con los equipos")
@RestController
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    // GET ALL
    @GetMapping("/all")
    public ResponseEntity<List<EquipoDTO>> getAllTeams() {
        try {
            List<EquipoDTO> equipos = equipoService.getAllTeams();
            if (equipos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(equipos);
        } catch (Exception ex) {
            System.out.println("Error al obtener equipos: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET POR ID
    @GetMapping("/id/{id}")
    public ResponseEntity<EquipoDTO> getTeamById(@PathVariable int id) {
        try {
            EquipoDTO equipo = equipoService.getTeamById(id);
            if (equipo == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(equipo);
        } catch (Exception ex) {
            System.out.println("Error al obtener equipo por id: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET POR NOMBRE
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<EquipoDTO>> getTeamByName(@PathVariable String nombre) {
        try {
            List<EquipoDTO> equipos = equipoService.getTeamByName(nombre);
            if (equipos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(equipos);
        } catch (Exception ex) {
            System.out.println("Error al obtener equipos por nombre: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //CREAT
    @PostMapping("/add")
    public ResponseEntity<String> addTeam(@RequestBody EquipoCreateDTO equipoDTO) {
        try {
            EquipoDTO nuevoEquipo = equipoService.addTeam(equipoDTO);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Equipo creado correctamente: " + nuevoEquipo.getNombreEquipo());
        } catch (Exception e) {
            System.out.println("Error al crear equipo: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear equipo");
        }
    }

    // PUT - ACTUALIZAR
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeam(@PathVariable int id, @RequestBody EquipoCreateDTO equipoDTO) {
        try {
            EquipoDTO updated = equipoService.updateTeam(id, equipoDTO);
            if (updated == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            System.out.println("Error al actualizar equipo: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar equipo");
        }
    }

    // DELETE - Borrar equipo
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable int id) {
        try {
            equipoService.deleteTeam(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error al borrar equipo: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
