package org.project.boulangerie.service;

import org.project.boulangerie.model.Produit;
import org.project.boulangerie.repository.ProduitRepository;
import org.springframework.stereotype.Service;
import spring.nx.NxRepository;
import spring.nx.NxService;

@Service
public class ProduitService extends NxService<Produit, Integer> {
    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository repository) {
        super(repository);
        this.produitRepository = repository;

    }
}
