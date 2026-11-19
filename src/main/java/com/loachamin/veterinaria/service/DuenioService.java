package com.loachamin.veterinaria.service;

import com.loachamin.veterinaria.model.Duenio;
import com.loachamin.veterinaria.repository.DuenioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DuenioService {

    private DuenioRepository duenioRepository;

    public DuenioService(DuenioRepository duenioRepository){
        this.duenioRepository = duenioRepository;
    }

    public List<Duenio> traerTodos(){
        return duenioRepository.findAll();
    }

    public Optional<Duenio> traerUno(int id) {
        return duenioRepository.findById(id);
    }

    public Duenio guardar(Duenio duenio){
        if (duenioRepository.findByCedula(duenio.getCedula()).isPresent()) {
            throw new IllegalStateException("Ya existe un dueño con esa cédula");
        }
        return duenioRepository.save(duenio);
    }

    public Optional<Duenio> actualizar(int id, Duenio datos) {
        return duenioRepository.findById(id).map(d -> {
            d.setNombre(datos.getNombre());
            d.setApellido(datos.getApellido());
            d.setCedula(datos.getCedula());
            d.setTelefono(datos.getTelefono());
            d.setEmail(datos.getEmail());
            return duenioRepository.save(d);
        });
    }

    public boolean eliminar(int id) {
        if (!duenioRepository.existsById(id)) return false;
        duenioRepository.deleteById(id);
        return true;
    }

    public Optional<Duenio> porCedula(String cedula) {
        return duenioRepository.findByCedula(cedula);
    }

    public List<Duenio> porApellido(String apellido) {
        return duenioRepository.findByApellidoContainingIgnoreCase(apellido);
    }
}