package org.project.boulangerie.service;

import org.project.boulangerie.model.MvtStock;
import org.project.boulangerie.repository.MvtStockRepository;
import org.springframework.stereotype.Service;
import spring.nx.NxService;

@Service
public class MvtStockService extends NxService<MvtStock, Integer> {
    private final MvtStockRepository mvtStockRepository;

    public MvtStockService(MvtStockRepository mvtStockRepository) {
        super(mvtStockRepository);
        this.mvtStockRepository = mvtStockRepository;
    }


}
