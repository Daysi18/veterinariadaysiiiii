package com.loachamin.veterinaria.repository;

import com.loachamin.veterinaria.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface MascotaRepository extends JpaRepository<Mascota, Integer> {
    List<Mascota> findByEspecie(String especie);

    @Query("SELECT m.especie, COUNT(m) FROM Mascota m GROUP BY m.especie")
    List<Object[]> contarPorEspecie();
}