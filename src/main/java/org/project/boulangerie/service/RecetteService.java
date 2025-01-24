package org.project.boulangerie.service;

import org.project.boulangerie.model.Recette;
import org.project.boulangerie.repository.RecetteRepository;
import org.springframework.stereotype.Service;
import spring.nx.NxRepository;
import spring.nx.NxService;

@Service
public class RecetteService extends NxService<Recette, Integer> {
    private final RecetteRepository recetteRepository;

    public RecetteService(RecetteRepository repository) {
        super(repository);
        this.recetteRepository = repository;

    }
}
