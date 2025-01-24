package org.project.boulangerie.service;

import org.project.boulangerie.model.Parfum;
import org.project.boulangerie.repository.ParfumRepository;
import org.springframework.stereotype.Service;
import spring.nx.NxRepository;
import spring.nx.NxService;

@Service
public class ParfumService extends NxService<Parfum, Integer> {

    public ParfumService(ParfumRepository repository) {
        super(repository);
    }

}
