package org.project.boulangerie.repository;

import org.project.boulangerie.model.Fournisseur;
import org.springframework.stereotype.Repository;
import spring.nx.NxRepository;

@Repository
public interface FournisseurRepository extends NxRepository<Fournisseur, Integer> {
}
