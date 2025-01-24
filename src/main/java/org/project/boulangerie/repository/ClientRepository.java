package org.project.boulangerie.repository;

import org.project.boulangerie.model.Client;
import org.springframework.stereotype.Repository;
import spring.nx.NxRepository;

@Repository
public interface ClientRepository extends NxRepository<Client, Integer> {
}
