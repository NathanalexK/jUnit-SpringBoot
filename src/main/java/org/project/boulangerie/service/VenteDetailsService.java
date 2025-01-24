package org.project.boulangerie.service;

import org.project.boulangerie.model.VenteDetail;
import org.project.boulangerie.repository.VenteDetailsRepository;
import org.springframework.stereotype.Service;
import spring.nx.NxRepository;
import spring.nx.NxService;

@Service
public class VenteDetailsService extends NxService<VenteDetail, Integer> {
    public VenteDetailsService(VenteDetailsRepository repository) {
        super(repository);
    }
}
