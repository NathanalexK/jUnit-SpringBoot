package org.project.boulangerie.service;

import org.project.boulangerie.model.CategorieProduit;
import org.project.boulangerie.repository.CategorieProduitRepository;
import org.springframework.stereotype.Service;
import spring.nx.NxService;


@Service
public class CategorieProduitService extends NxService<CategorieProduit, Integer> {
    private final CategorieProduitRepository categorieProduitRepository;

    public CategorieProduitService(CategorieProduitRepository repository) {
        super(repository);
        this.categorieProduitRepository = repository;
    }
}
