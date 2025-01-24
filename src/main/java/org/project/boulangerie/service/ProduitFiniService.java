package org.project.boulangerie.service;

import jakarta.transaction.Transactional;
import org.project.boulangerie.form.ProduitFiniForm;
import org.project.boulangerie.model.Produit;
import org.project.boulangerie.model.ProduitFini;
import org.project.boulangerie.model.Recette;
import org.project.boulangerie.repository.ProduitFiniRepository;
import org.project.boulangerie.repository.ProduitRepository;
import org.springframework.stereotype.Service;
import spring.nx.NxRepository;
import spring.nx.NxService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProduitFiniService extends NxService<ProduitFini, Integer> {
    private final ProduitFiniRepository produitFiniRepository;
    private final TypeProduitService typeProduitService;
    private final ProduitService produitService;

    public ProduitFiniService(ProduitFiniRepository repository, TypeProduitService typeProduitService, ProduitService produitService) {
        super(repository);
        this.produitFiniRepository = repository;
        this.typeProduitService = typeProduitService;
        this.produitService = produitService;
    }

    @Override
    public ProduitFini save(ProduitFini produitFini) throws Exception {
        Produit produit = new Produit();
        produit.setNom(produitFini.getNom());
        produit.setTypeProduit(typeProduitService.getTypeProduitFromCode("PF"));
        produit.setPrixVente(produitFini.getPrixVente());
        produit = produitService.save(produit);

        produitFini.setProduit(produit);
        produitFini.getRecettes().forEach(recette -> {
            recette.setProduitFini(produitFini);
        });
//        return produitFini;
        return produitFiniRepository.save(produitFini);
    }

    @Transactional
    public ProduitFini save(ProduitFiniForm form) throws Exception {
        ProduitFini produitFini = form.getProduitFini() != null ? form.getProduitFini() : new ProduitFini();
        Produit produit = produitFini.getProduit() != null ? produitFini.getProduit() : new Produit();

        produit.setNom(form.getNom());
        produit.setTypeProduit(typeProduitService.getTypeProduitFromCode("PF"));
        produit.setUnite(form.getUnite());
        produit.setPrixVente(form.getPrixVente());
        produit = produitService.save(produit);

        produitFini.setCategorie(form.getCategorieProduit());
        produitFini.setProduit(produit);
        produitFini.setParfum(form.getParfum());

        List<Recette> recettes = new ArrayList<>();
        form.getFilles().forEach((fille) -> {
            if(fille.getIngredient() == null) return;

            Recette recette = fille.getRecette() != null ? fille.getRecette() : new Recette();
            recette.setProduitFini(produitFini);
            recette.setIngredient(fille.getIngredient());
            recette.setQuantite(fille.getQuantite());
            recettes.add(recette);
        });
        produitFini.setRecettes(recettes);
        return produitFiniRepository.save(produitFini);

    }
}
