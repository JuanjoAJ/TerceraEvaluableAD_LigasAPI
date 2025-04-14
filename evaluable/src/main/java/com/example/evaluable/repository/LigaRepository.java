package com.example.evaluable.repository;

import com.example.evaluable.model.Liga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigaRepository extends JpaRepository<Liga, Integer> {
    List<Liga> findByNombreLigaContainingIgnoreCase(String nombre);
}
