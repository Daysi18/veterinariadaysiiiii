package com.loachamin.veterinaria.service;


import com.loachamin.veterinaria.model.Mascota;
import com.loachamin.veterinaria.repository.MascotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MascotaService {
    private MascotaRepository mascotaRepository;

    public MascotaService(MascotaRepository mascotaRepository){
        this.mascotaRepository = mascotaRepository;

    }

    //TREAR TODOS
    public List<Mascota> traerTodos(){
        return mascotaRepository.findAll();
    }



    //TRAER UNO
    public Optional<Mascota> traerUno(int id) {
        return mascotaRepository.findById(id);
    }

    //GUardar
    public Mascota  guardar (Mascota mascota){
        return mascotaRepository.save(mascota);
    }
}
