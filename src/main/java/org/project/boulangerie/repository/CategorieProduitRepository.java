package org.project.boulangerie.repository;

import org.project.boulangerie.model.CategorieProduit;
import org.springframework.stereotype.Repository;
import spring.nx.NxRepository;

@Repository
public interface CategorieProduitRepository extends NxRepository<CategorieProduit, Integer> {
}
