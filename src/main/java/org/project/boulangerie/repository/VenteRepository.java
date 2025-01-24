package org.project.boulangerie.repository;

import org.project.boulangerie.model.Vente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import spring.nx.NxRepository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VenteRepository extends NxRepository<Vente, Integer> {
    @Query("select v from Vente v where v.dateHeure = ?1")
    List<Vente> findByDate(@Nullable LocalDate dateHeure);
}
