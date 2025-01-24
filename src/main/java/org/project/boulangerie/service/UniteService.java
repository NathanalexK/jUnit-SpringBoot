package org.project.boulangerie.service;

import org.project.boulangerie.model.Unite;
import org.project.boulangerie.repository.UniteRepository;
import org.springframework.stereotype.Service;
import spring.nx.NxRepository;
import spring.nx.NxService;

@Service
public class UniteService extends NxService<Unite, Integer> {
    private final UniteRepository uniteRepository;

    public UniteService(UniteRepository repository) {
        super(repository);
        this.uniteRepository = repository;
    }
}
