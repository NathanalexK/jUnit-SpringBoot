package org.project.boulangerie.service;

import org.project.boulangerie.model.Client;
import org.project.boulangerie.repository.ClientRepository;
import org.springframework.stereotype.Service;
import spring.nx.NxRepository;
import spring.nx.NxService;

@Service
public class ClientService extends NxService<Client, Integer> {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository repository) {
        super(repository);
        this.clientRepository = repository;
    }
}
