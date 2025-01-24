package org.project.boulangerie.repository;

import org.project.boulangerie.model.Unite;
import org.springframework.stereotype.Repository;
import spring.nx.NxRepository;

@Repository
public interface UniteRepository extends NxRepository<Unite, Integer> {
}
