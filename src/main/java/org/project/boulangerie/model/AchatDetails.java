package org.project.boulangerie.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "achat_details")
public class AchatDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('achat_details_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_achat", nullable = false)
    private Achat achatMere;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_ingredient", nullable = false)
    private Ingredient ingredient;

    @Column(name = "quantite", nullable = false)
    private Double quantite;

    @Column(name = "d_prix_unitaire", nullable = false)
    private Double dPrixUnitaire;

    @Transient
    private String nomClient;

    @Transient
    private LocalDate tDateAchat;

    public Double getDPrixUnitaire() {
        if(dPrixUnitaire != null) {
            return dPrixUnitaire;
        }

        if(ingredient != null) {
            setDPrixUnitaire(ingredient.getPrixAchat());
        }

        return dPrixUnitaire;
    }

    public LocalDate getTDateAchat() {
        if(this.getAchatMere() != null) {
            return this.getAchatMere().getDateHeure();
        }
        return null;

    }

//    public String getNomClient() {
//        return this.getAchatMere().get;
//    }

    public MvtStock genererEntreeStock() {
        MvtStock mvtStock = MvtStock.entreeStock(this.getIngredient().getProduit(), this.getQuantite());
        mvtStock.setDPrixUnitaire(this.getDPrixUnitaire());
        return mvtStock;
    }
}