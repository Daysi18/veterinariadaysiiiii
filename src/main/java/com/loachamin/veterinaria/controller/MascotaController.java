package com.loachamin.veterinaria.controller;

import com.loachamin.veterinaria.model.Mascota;
import com.loachamin.veterinaria.service.MascotaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/mascota")
public class MascotaController {

    private MascotaService mascotaService;

    public MascotaController(MascotaService mascotaService){
        this.mascotaService = mascotaService;
    }

    @GetMapping
    public List<Mascota> verTodos(){
        return mascotaService.traerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mascota> traerUno(@PathVariable int id){
        return mascotaService.traerUno(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Mascota> guardar(@RequestBody Mascota mascota){
        Mascota nuevaMascota = mascotaService.guardar(mascota);
        return new ResponseEntity<>(nuevaMascota, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mascota> actualizar(@PathVariable int id, @RequestBody Mascota mascota){
        return mascotaService.actualizar(id, mascota)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id){
        return mascotaService.eliminar(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/especie/{especie}")
    public List<Mascota> porEspecie(@PathVariable String especie){
        return mascotaService.porEspecie(especie);
    }

    @GetMapping("/conteo-especies")
    public Map<String, Long> conteoEspecies(){
        return mascotaService.conteoEspecies();
    }
}