package org.project.boulangerie.repository;

import org.project.boulangerie.model.MvtStock;
import org.springframework.stereotype.Repository;
import spring.nx.NxRepository;

@Repository
public interface MvtStockRepository extends NxRepository<MvtStock, Integer> {
}
