package org.project.boulangerie.model;

import annotations.forms.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('ingredient_id_seq')")
    @Column(name = "id", nullable = false)
    @Input(type = "hidden")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_produit", nullable = false)
    @SkipInput
    private Produit produit;

    @Transient
    @Hidden
    @Input(name = "produit", type = "hidden")
    private Integer idProduit;

    @Transient
    @Label("Nom Ingredient")
    @Input(type = "text")
    private String nomIngredient;

    @Transient
    @Input(type = "number")
    private Double prixAchat;

    @Transient
    @Select
    private Unite unite;

    @Transient
    @SkipInput
    private String uniteLib;



    public MvtStock genererEntreeMvtStock(Double qte) {
        MvtStock mvtStock = this.getProduit().genererEntreeStock(qte);
        mvtStock.setDPrixUnitaire(this.getPrixAchat());
        return mvtStock;
    }

    public MvtStock genererSortieMvtStock(Double qte) throws Exception {
        MvtStock mvtStock = this.getProduit().genererSortieStock(qte);
        mvtStock.setDPrixUnitaire(this.getPrixAchat());
        return mvtStock;
    }

    public Integer getIdProduit() {
        if(this.getProduit() != null){
            return this.getProduit().getId();
        }
        return idProduit;
    }

    public String getNomIngredient() {
        if(this.getProduit() != null) {
            return this.getProduit().getNom();
        }
        return nomIngredient;
    }

    public Double getPrixAchat() {
        if(this.getProduit() != null) {
            return this.getProduit().getPrixAchat();
        }
        return prixAchat;
    }

    public String getUniteLib() {
        if(this.getProduit() != null) {
            return this.getProduit().getUnite().getNom();
        }
        return uniteLib;
    }


    @Override
    public String toString() {
        return this.getProduit().getNom();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Ingredient that = (Ingredient) object;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}