package org.project.boulangerie.repository;

import org.project.boulangerie.model.Production;
import org.springframework.stereotype.Repository;
import spring.nx.NxRepository;

@Repository
public interface ProductionRepository extends NxRepository<Production, Integer> {
}
