package com.example.evaluable.repository;

import com.example.evaluable.model.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Integer> {
    List<Entrenador> findByNombreContainingIgnoreCase(String nombre);

}
