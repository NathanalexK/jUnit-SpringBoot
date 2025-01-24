package org.project.boulangerie.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommissionGenreDTO {
    private String nom;
    private Double total;

    public CommissionGenreDTO() {

    }

    public CommissionGenreDTO(String nom, Double total) {
        this.nom = nom;
        this.total = total;
    }
}
