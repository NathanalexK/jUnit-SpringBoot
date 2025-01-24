package org.project.boulangerie.dto;

import lombok.Getter;
import lombok.Setter;
import org.project.boulangerie.model.ProduitFini;

import java.util.List;

@Getter
@Setter
public class RecetteDTO {
    private String nom;
    private Double qte;
    private String unite;
    private Double stock;


//    public RecetteDTO(ProduitFini pf) {
//    }
}
