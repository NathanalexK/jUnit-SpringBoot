package org.project.boulangerie.form;

import annotations.forms.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.project.boulangerie.model.Ingredient;
import org.project.boulangerie.model.Produit;
import org.project.boulangerie.model.Unite;

@Getter
@Setter
public class IngredientForm {
    @Input(type = "hidden", name = "ingredient")
    private Integer idIngredient;

    @SkipInput
    private Ingredient ingredient;

    @Hidden
    @Input(name = "produit", type = "hidden")
    private Integer idProduit;

    @Label("Nom Ingredient")
    @Input(type = "text")
    private String nomIngredient;

    @Input(type = "number")
    private Double prixAchat;

    @Select
    private Unite unite;

    public IngredientForm(Ingredient ingredient){
        if(ingredient == null) return;

        this.setIdIngredient(ingredient.getId());
        Produit produit = ingredient.getProduit();
        if(produit != null) {
            this.setNomIngredient(produit.getNom());
            this.setPrixAchat(produit.getPrixAchat());
            this.setUnite(produit.getUnite());
        }
    }
}
