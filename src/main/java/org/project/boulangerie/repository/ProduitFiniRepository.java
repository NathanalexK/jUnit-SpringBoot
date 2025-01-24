package org.project.boulangerie.repository;

import org.project.boulangerie.model.ProduitFini;
import org.springframework.stereotype.Repository;
import spring.nx.NxRepository;

@Repository
public interface ProduitFiniRepository extends NxRepository<ProduitFini, Integer> {
}
