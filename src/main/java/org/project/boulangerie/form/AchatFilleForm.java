package org.project.boulangerie.form;

import annotations.forms.Input;
import annotations.forms.Select;
import lombok.Getter;
import lombok.Setter;
import org.project.boulangerie.model.Ingredient;

@Getter
@Setter
public class AchatFilleForm {
    @Select(append = "required")
    private Ingredient ingredient;

    @Input(type = "number", step = "0.01",append = "disabled")
    private Double prixUnitaire;

    @Input(type = "number", step = "0.01", append = "required")
    private Double quantite;

    @Input(type = "number", step = "0.01", append = "disabled")
    private Double prixTotal;
}
