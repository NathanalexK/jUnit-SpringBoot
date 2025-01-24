package org.project.boulangerie.repository;

import org.project.boulangerie.model.Recette;
import org.springframework.stereotype.Repository;
import spring.nx.NxRepository;


@Repository
public interface RecetteRepository extends NxRepository<Recette, Integer> {
}
