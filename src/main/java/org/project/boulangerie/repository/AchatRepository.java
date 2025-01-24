package org.project.boulangerie.repository;

import org.project.boulangerie.model.Achat;
import org.springframework.stereotype.Repository;
import spring.nx.NxRepository;

@Repository
public interface AchatRepository extends NxRepository<Achat, Integer> {
}
