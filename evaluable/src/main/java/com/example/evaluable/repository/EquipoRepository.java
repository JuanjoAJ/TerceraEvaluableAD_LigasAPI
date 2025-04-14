package com.example.evaluable.repository;

import com.example.evaluable.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
    List<Equipo> findByNombreEquipoContainingIgnoreCase(String nombre);
}
