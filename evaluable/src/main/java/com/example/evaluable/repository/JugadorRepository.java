package com.example.evaluable.repository;

import com.example.evaluable.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JugadorRepository extends JpaRepository<Jugador, Integer> {
    List<Jugador> findByNombreContainingIgnoreCase(String nombre);
}
