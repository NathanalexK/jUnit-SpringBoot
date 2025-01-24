package org.project.boulangerie.service;

import org.project.boulangerie.model.TypeProduit;
import org.project.boulangerie.repository.TypeProduitRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import spring.nx.NxRepository;
import spring.nx.NxService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TypeProduitService extends NxService<TypeProduit, Integer> {
    private final TypeProduitRepository typeProduitRepository;

    public TypeProduitService(TypeProduitRepository repository) {
        super(repository);
        this.typeProduitRepository = repository;
    }

    @Cacheable("type_produits")
    public Map<String, TypeProduit> getTypeProduitMap() {
        List<TypeProduit> typeProduitList = typeProduitRepository.findAll();
        Map<String, TypeProduit> typeProduitMap = new HashMap<>();
        for(TypeProduit typeProduit: typeProduitList) {
            typeProduitMap.put(typeProduit.getCode(), typeProduit);
        }
        return typeProduitMap;
    }

    public TypeProduit getTypeProduitFromCode(String code) {
        return this.getTypeProduitMap().get(code);
    }
}
