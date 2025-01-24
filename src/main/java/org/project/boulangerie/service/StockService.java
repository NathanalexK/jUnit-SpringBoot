package org.project.boulangerie.service;

import org.project.boulangerie.model.Stock;
import org.project.boulangerie.repository.StockRepository;
import org.springframework.stereotype.Service;
import spring.nx.NxRepository;
import spring.nx.NxService;

@Service
public class StockService extends NxService<Stock, Integer> {
    public StockService(StockRepository repository) {
        super(repository);
    }
}
