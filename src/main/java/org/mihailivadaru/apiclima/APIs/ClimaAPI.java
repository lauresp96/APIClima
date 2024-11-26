package org.mihailivadaru.apiclima.APIs;

import org.mihailivadaru.apiclima.entidades.Clima;
import org.mihailivadaru.apiclima.servicios.ServicioClima;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clima")
public class ClimaAPI {

    @Autowired
    private ServicioClima servicioClima;


    @GetMapping
    public ResponseEntity<List<Clima>> obtenerClimas() {
        List<Clima> climas = servicioClima.obtenerTodosClimas();
        return ResponseEntity.ok(climas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clima> obtenerClimaPorId(@PathVariable Long id) {
        Optional<Clima> clima = servicioClima.obtenerClimaPorId(id);
        return clima.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Clima> crearClima(@RequestBody Clima clima) {
        Clima nuevoClima = servicioClima.guardarClima(clima);
        return ResponseEntity.ok(nuevoClima);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarClima(@PathVariable Long id) {
        boolean eliminado = servicioClima.eliminarClima(id);
        if (eliminado) {
            return ResponseEntity.ok("Clima eliminado con exito");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
