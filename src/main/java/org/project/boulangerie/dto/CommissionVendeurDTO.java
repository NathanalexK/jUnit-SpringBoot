package org.project.boulangerie.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommissionVendeurDTO {
    private Integer id;
    private String nom;
    private String genre;
    private Double total;

    public CommissionVendeurDTO() {
    }
}
