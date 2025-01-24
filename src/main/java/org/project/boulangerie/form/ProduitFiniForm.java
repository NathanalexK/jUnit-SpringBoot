package org.project.boulangerie.form;

import annotations.forms.FormRepeat;
import annotations.forms.Input;
import annotations.forms.Select;
import annotations.forms.SkipInput;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.project.boulangerie.model.*;
import org.project.boulangerie.service.ProduitFiniService;

import java.util.List;

@Getter
@Setter
public class ProduitFiniForm {
    @Input(type = "hidden", name = "produitFini")
    private Integer idProduitFini;

    @SkipInput
    private ProduitFini produitFini;

    @Input(type = "text")
    private String nom;

    @Select
    private CategorieProduit categorieProduit;

    @Select
    private Unite unite;

    @Input(type = "number", step = "0.01")
    private Double prixVente;

    @Select
    private Parfum parfum;

    @FormRepeat(title = "Insertion Ingredient", formClass = ProduitFiniFilleForm.class, rows = 1)
    private List<ProduitFiniFilleForm> filles;

    public ProduitFiniForm(){}


    public ProduitFiniForm(ProduitFini pf) {
        if(pf == null) return;
        this.setIdProduitFini(pf.getId());
        this.setCategorieProduit(pf.getCategorie());
        this.setFilles(pf.getRecettes().stream().map(recette -> new ProduitFiniFilleForm(recette)).toList());

        Produit produit = pf.getProduit();
        if(produit != null) {
            setNom(produit.getNom());
            setUnite(produit.getUnite());
            setPrixVente(produit.getPrixVente());
//            setFilles(se);
        }
    }
}
