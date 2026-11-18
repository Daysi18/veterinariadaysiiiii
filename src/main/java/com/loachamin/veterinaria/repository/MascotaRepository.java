package com.loachamin.veterinaria.repository;

import com.loachamin.veterinaria.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotaRepository extends JpaRepository <Mascota, Integer> {
}
