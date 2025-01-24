package org.project.boulangerie.service;

import jakarta.transaction.Transactional;
import org.project.boulangerie.model.MvtStock;
import org.project.boulangerie.model.Production;
import org.project.boulangerie.repository.MvtStockRepository;
import org.project.boulangerie.repository.ProductionRepository;
import org.springframework.stereotype.Service;
import spring.nx.NxRepository;
import spring.nx.NxService;

import java.util.List;

@Service
public class ProductionService extends NxService<Production, Integer> {

    private final ProductionRepository productionRepository;
    private final MvtStockRepository mvtStockRepository;

    public ProductionService(ProductionRepository repository,
                             ProductionRepository productionRepository,
                             MvtStockRepository mvtStockRepository) {
        super(repository);
        this.productionRepository = productionRepository;
        this.mvtStockRepository = mvtStockRepository;
    }

//    @Override
    @Transactional
    public Production save(Production production) throws Exception {
        List<MvtStock> mvtStockList = production.genererMvtSock();
        productionRepository.save(production);
        mvtStockRepository.saveAll(mvtStockList);
        return production;
    }
}
