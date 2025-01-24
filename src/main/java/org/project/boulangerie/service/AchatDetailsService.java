package org.project.boulangerie.service;

import org.project.boulangerie.model.AchatDetails;
import org.project.boulangerie.repository.AchatDetailsRepository;
import org.project.boulangerie.repository.AchatRepository;
import org.springframework.stereotype.Service;
import spring.nx.NxRepository;
import spring.nx.NxService;

@Service
public class AchatDetailsService extends NxService<AchatDetails, Integer> {
    public AchatDetailsService(AchatDetailsRepository repository) {
        super(repository);
    }
}
