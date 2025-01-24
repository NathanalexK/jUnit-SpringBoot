package org.project.boulangerie.form;

import annotations.forms.FormRepeat;
import annotations.forms.Input;
import annotations.forms.Select;
import annotations.forms.SkipInput;
import lombok.Getter;
import lombok.Setter;
import org.project.boulangerie.model.Achat;
import org.project.boulangerie.model.Fournisseur;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AchatForm {
    @Input(type = "hidden", name = "id")
    private Integer id;

    @SkipInput
    private Achat achat;

    @Input(type = "date", append = " disabled")
    private LocalDate dateAchat = LocalDate.now();

    @Select
    private Fournisseur fournisseur;

    @FormRepeat(title = "Inserer Achat Ingredient", formClass = AchatFilleForm.class, rows = 1)
    List<AchatFilleForm> achatFilleForms = new ArrayList<>();
}
