package org.project.boulangerie.repository;

import org.project.boulangerie.model.AchatDetails;
import org.springframework.stereotype.Repository;
import spring.nx.NxRepository;

@Repository
public interface AchatDetailsRepository extends NxRepository<AchatDetails, Integer> {
}
