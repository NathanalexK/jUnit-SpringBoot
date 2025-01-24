package org.project.boulangerie.service;

import jakarta.transaction.Transactional;
import org.project.boulangerie.form.IngredientForm;
import org.project.boulangerie.model.Ingredient;
import org.project.boulangerie.model.Produit;
import org.project.boulangerie.model.TypeProduit;
import org.project.boulangerie.repository.IngredientRepository;
import org.project.boulangerie.repository.ProduitRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import spring.nx.NxRepository;
import spring.nx.NxService;

import java.util.Map;

@Service
public class IngredientService extends NxService<Ingredient, Integer> {
    private final IngredientRepository ingredientRepository;
    private final TypeProduitService typeProduitService;
    private final ProduitService produitService;
    private final ProduitRepository produitRepository;

    public IngredientService(IngredientRepository repository, TypeProduitService typeProduitService, ProduitService produitService,
                             ProduitRepository produitRepository) {
        super(repository);
        this.ingredientRepository = repository;
        this.typeProduitService = typeProduitService;
        this.produitService = produitService;
        this.produitRepository = produitRepository;
    }

//    @Override
    @Transactional
    public Ingredient save(IngredientForm ingredientForm) {
        Ingredient ingredient = ingredientForm.getIngredient() != null ? ingredientForm.getIngredient() : new Ingredient();
        Produit produit = ingredient.getProduit() != null ? ingredient.getProduit() : new Produit();

        produit.setNom(ingredientForm.getNomIngredient());
        produit.setTypeProduit(typeProduitService.getTypeProduitFromCode("INGR"));
        produit.setUnite(ingredientForm.getUnite());
        produit.setPrixAchat(ingredientForm.getPrixAchat());
        produit = produitRepository.save(produit);

        ingredient.setProduit(produit);
        return ingredientRepository.save(ingredient);
//        Produit produit = ingredient.getProduit() != null ? ingredient.getProduit() : new Produit();
//        System.out.println("OKKKKKKKKKKK");
//        produit.setPrixAchat(ingredient.getPrixAchat());
//        produit.setNom(ingredient.getNomIngredient());
//        produit.setTypeProduit(typeProduitService.getTypeProduitFromCode("INGR"));
//        produit.setUnite(ingredient.getUnite());
//        produit = produitService.save(produit);
//        ingredient.setProduit(produit);
//        ingredientRepository.save(ingredient);
//        return ingredient;
    }
}
