package org.project.boulangerie.repository;

import org.project.boulangerie.model.VenteDetail;
import org.springframework.stereotype.Repository;
import spring.nx.NxRepository;

@Repository
public interface VenteDetailsRepository extends NxRepository<VenteDetail, Integer> {
}
