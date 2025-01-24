package org.project.boulangerie.form;


import annotations.forms.Input;
import annotations.forms.Select;
import lombok.Getter;
import lombok.Setter;
import org.project.boulangerie.model.ProduitFini;

@Getter
@Setter
public class RecommendationForm {
    @Select
    private ProduitFini produitFini;

    @Select
    private Integer mois;

    @Input(type = "number", append = "min='2000' max='2050'")
    private Integer annee;
}
