package org.project.boulangerie.form;

import annotations.forms.Input;
import annotations.forms.Select;
import lombok.Getter;
import lombok.Setter;
import org.project.boulangerie.model.Ingredient;
import org.project.boulangerie.model.ProduitFini;

@Getter
@Setter
public class VenteFilleForm {
    @Select
    private ProduitFini produitFini;

//    @Input(type = "number", step = "0.01")
//    private Double prixUnitaire;
    @Input(type = "number", step = "0.01")
    private Double quantite;

}
