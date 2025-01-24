package org.project.boulangerie.repository;

import org.project.boulangerie.model.Vendeur;
import org.springframework.stereotype.Repository;
import spring.nx.NxRepository;

@Repository
public interface VendeurRepository extends NxRepository<Vendeur, Integer> {

}