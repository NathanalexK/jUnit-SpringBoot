package org.project.boulangerie.repository;

import org.project.boulangerie.model.Produit;
import org.springframework.stereotype.Repository;
import spring.nx.NxRepository;

@Repository
public interface ProduitRepository extends NxRepository<Produit, Integer> {
}
