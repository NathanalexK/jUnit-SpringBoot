package org.project.boulangerie.repository;

import jakarta.persistence.Id;
import org.project.boulangerie.model.Parfum;
import org.springframework.stereotype.Repository;
import spring.nx.NxRepository;

@Repository
public interface ParfumRepository extends NxRepository<Parfum, Integer> {
}
