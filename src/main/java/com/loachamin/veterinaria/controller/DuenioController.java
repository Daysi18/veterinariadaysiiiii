package com.loachamin.veterinaria.controller;

import com.loachamin.veterinaria.model.Duenio;
import com.loachamin.veterinaria.service.DuenioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/duenio")
public class DuenioController {

    private DuenioService duenioService;

    public DuenioController(DuenioService duenioService){
        this.duenioService = duenioService;
    }

    @GetMapping
    public List<Duenio> verTodos(){
        return duenioService.traerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Duenio> traerUno(@PathVariable int id){
        return duenioService.traerUno(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Duenio duenio){
        try {
            Duenio nuevo = duenioService.guardar(duenio);
            return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Duenio> actualizar(@PathVariable int id, @RequestBody Duenio duenio){
        return duenioService.actualizar(id, duenio)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id){
        return duenioService.eliminar(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/cedula/{cedula}")
    public ResponseEntity<Duenio> porCedula(@PathVariable String cedula){
        return duenioService.porCedula(cedula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/apellido/{apellido}")
    public List<Duenio> porApellido(@PathVariable String apellido){
        return duenioService.porApellido(apellido);
    }
}