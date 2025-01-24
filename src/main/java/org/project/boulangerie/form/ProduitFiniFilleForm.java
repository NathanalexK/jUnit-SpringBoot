package org.project.boulangerie.form;

import annotations.forms.Input;
import annotations.forms.Select;
import annotations.forms.SkipInput;
import lombok.Getter;
import lombok.Setter;
import org.project.boulangerie.model.Ingredient;
import org.project.boulangerie.model.ProduitFini;
import org.project.boulangerie.model.Recette;

@Getter
@Setter
public class ProduitFiniFilleForm {
    @Input(type = "hidden", name = "recette")
    private Integer idRecette;

    @SkipInput
    private Recette recette;

    @Select
    private Ingredient ingredient;

    @Input(type = "number", step = "0.001")
    private Double quantite;

    public ProduitFiniFilleForm(){}

    public ProduitFiniFilleForm(Recette recette) {
        if(recette == null) return;
        this.setIdRecette(recette.getId());
        this.setIngredient(recette.getIngredient());
        this.setQuantite(recette.getQuantite());
    }
}
