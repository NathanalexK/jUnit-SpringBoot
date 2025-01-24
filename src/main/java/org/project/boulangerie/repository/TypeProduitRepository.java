package org.project.boulangerie.repository;

import org.project.boulangerie.model.TypeProduit;
import org.springframework.stereotype.Repository;
import spring.nx.NxRepository;


@Repository
public interface TypeProduitRepository extends NxRepository<TypeProduit, Integer> {
}
