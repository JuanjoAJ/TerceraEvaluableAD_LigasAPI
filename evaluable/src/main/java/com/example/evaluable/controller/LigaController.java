package com.example.evaluable.controller;

import com.example.evaluable.dtos.LigaDTO;
import com.example.evaluable.service.LigaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Liga", description = "Operaciones relacionadas con la liga")
@RestController
@RequestMapping("/ligas")
public class LigaController {

    @Autowired
    private LigaService ligaService;

    // GET ALL
    @GetMapping("/all")
    public ResponseEntity<List<LigaDTO>> getAllLigas() {
        try {
            List<LigaDTO> ligas = ligaService.getAllLeague();
            if (ligas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(ligas);
        } catch (Exception ex) {
            System.out.println("Error al obtener ligas: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET POR ID
    @GetMapping("/id/{id}")
    public ResponseEntity<LigaDTO> getLigaById(@PathVariable int id) {
        try {
            LigaDTO liga = ligaService.getLeagueById(id);
            if (liga == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(liga);
        } catch (Exception ex) {
            System.out.println("Error al obtener liga por id: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET POR NOMBRE
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<LigaDTO>> getLigaByName(@PathVariable String nombre) {
        try {
            List<LigaDTO> ligas = ligaService.getLeagueByName(nombre);
            if (ligas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(ligas);
        } catch (Exception ex) {
            System.out.println("Error al obtener ligas por nombre: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<LigaDTO> addLiga(@RequestBody LigaDTO ligaDTO) {
        try {
            LigaDTO nuevaLiga = ligaService.addLeague(ligaDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaLiga);
        } catch (Exception ex) {
            System.out.println("Error al añadir liga: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LigaDTO> updateLiga(@PathVariable int id, @RequestBody LigaDTO ligaDTO) {
        try {
            LigaDTO actualizada = ligaService.updateLiga(id, ligaDTO);
            if (actualizada == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(actualizada);
        } catch (Exception ex) {
            System.out.println("Error al actualizar liga: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLiga(@PathVariable int id) {
        try {
            ligaService.deleteLeague(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println("Error al borrar liga: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
