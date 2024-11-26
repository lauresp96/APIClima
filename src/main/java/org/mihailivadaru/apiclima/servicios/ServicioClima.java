package org.mihailivadaru.apiclima.servicios;

import org.mihailivadaru.apiclima.entidades.Clima;
import org.mihailivadaru.apiclima.repositorios.RepositorioClima;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioClima {

    @Autowired
    private RepositorioClima repositorioClima;

    public List<Clima> obtenerTodosClimas() {
        return repositorioClima.findAll();
    }

    public Optional<Clima> obtenerClimaPorId(Long id) {
        return repositorioClima.findById(id);
    }

    public Clima guardarClima(Clima clima) {
        return repositorioClima.save(clima);
    }

    public boolean eliminarClima(Long id) {
        if (repositorioClima.existsById(id)) {
            repositorioClima.deleteById(id);
            return true;
        }
        return false;
    }
}
