package com.loachamin.veterinaria.service;

import com.loachamin.veterinaria.model.Mascota;
import com.loachamin.veterinaria.repository.MascotaRepository;
import org.springframework.stereotype.Service;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MascotaService {

    private MascotaRepository mascotaRepository;

    public MascotaService(MascotaRepository mascotaRepository){
        this.mascotaRepository = mascotaRepository;
    }

    public List<Mascota> traerTodos(){
        return mascotaRepository.findAll();
    }

    public Optional<Mascota> traerUno(int id) {
        return mascotaRepository.findById(id);
    }

    public Mascota guardar(Mascota mascota){
        return mascotaRepository.save(mascota);
    }

    public Optional<Mascota> actualizar(int id, Mascota datos) {
        return mascotaRepository.findById(id).map(m -> {
            m.setNombre(datos.getNombre());
            m.setEspecie(datos.getEspecie());
            m.setEdad(datos.getEdad());
            m.setDuenio(datos.getDuenio());
            return mascotaRepository.save(m);
        });
    }

    public boolean eliminar(int id) {
        if (!mascotaRepository.existsById(id)) return false;
        mascotaRepository.deleteById(id);
        return true;
    }

    public List<Mascota> porEspecie(String especie) {
        return mascotaRepository.findByEspecie(especie);
    }

    public Map<String, Long> conteoEspecies() {
        Map<String, Long> resultado = new LinkedHashMap<>();
        for (Object[] fila : mascotaRepository.contarPorEspecie()) {
            resultado.put((String) fila[0], (Long) fila[1]);
        }
        return resultado;
    }
}