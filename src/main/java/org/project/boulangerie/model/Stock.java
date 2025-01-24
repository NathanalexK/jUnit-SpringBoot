package org.project.boulangerie.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Getter
@Setter
@Entity
@Immutable
@Table(name = "v_stock")
public class Stock {
    @Id
    @Column(name = "id")
    private Integer id;

//    @Column(name = "id_produit")
//    private Integer idProduit;

    @OneToOne(targetEntity = Produit.class)
    @JoinColumn(name = "id_produit", referencedColumnName = "id")
//    @Transient
    private Produit produit;

    @Column(name = "qte")
    private Double quantite;

    @Transient
    private String nomProduit;

    @Transient
    private Double prixAchat;

    @Transient
    private Double prixVente;


    public String getNomProduit() {
        if(produit != null) {
            return produit.getId() + " " +  produit.getNom();
        }
        return nomProduit;
    }

    public Double getPrixAchat() {
        if(produit != null) {
            return produit.getPrixAchat();
        }
        return null;
    }

    public Double getPrixVente() {
        if(produit != null) {
            return produit.getPrixVente();
        }
        return null;
    }

    @Override
    public String toString() {
        return String.valueOf(quantite);
    }

}
