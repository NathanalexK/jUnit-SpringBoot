package org.project.boulangerie.form;

import annotations.forms.FormRepeat;
import annotations.forms.Input;
import annotations.forms.Select;
import annotations.forms.SkipInput;
import lombok.Getter;
import lombok.Setter;
import org.project.boulangerie.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class VenteForm {
    @Input(type = "hidden", name = "vente")
    private Integer id;

    @SkipInput
    private Vente vente;

    @Select
    private Vendeur vendeur;

    @Input(type = "date")
    private LocalDate dateVente = LocalDate.now();

    @Select
    private Client client;

    @FormRepeat(title = "Inserer Vente ProduitFini", formClass = VenteFilleForm.class, rows = 1)
    List<VenteFilleForm> venteFilleForms = new ArrayList<>();
}
