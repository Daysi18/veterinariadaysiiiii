package com.loachamin.veterinaria.repository;

import com.loachamin.veterinaria.model.Duenio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface DuenioRepository extends JpaRepository<Duenio, Integer> {
    Optional<Duenio> findByCedula(String cedula);
    List<Duenio> findByApellidoContainingIgnoreCase(String apellido);
}