package org.project.boulangerie.service;

import org.project.boulangerie.model.Fournisseur;
import org.project.boulangerie.repository.FournisseurRepository;
import org.springframework.stereotype.Service;
import spring.nx.NxRepository;
import spring.nx.NxService;

@Service
public class FournisseurService extends NxService<Fournisseur, Integer> {
    public FournisseurService(FournisseurRepository repository) {
        super(repository);
    }
}
