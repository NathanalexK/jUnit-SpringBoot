package org.project.boulangerie.repository;

import org.project.boulangerie.model.Stock;
import org.springframework.stereotype.Repository;
import spring.nx.NxRepository;

@Repository
public interface StockRepository extends NxRepository<Stock, Integer> {
}
