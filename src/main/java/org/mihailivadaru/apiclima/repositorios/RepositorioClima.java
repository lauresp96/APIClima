package org.mihailivadaru.apiclima.repositorios;

import org.mihailivadaru.apiclima.entidades.Clima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioClima extends JpaRepository<Clima, Long> {
}
