package org.project.boulangerie.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "mvt_stock")
public class MvtStock {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mvt_stock_id_gen")
    @SequenceGenerator(name = "mvt_stock_id_gen", sequenceName = "mvt_stock_fille_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_produit", nullable = false)
    private Produit produit;

    @ColumnDefault("0")
    @Column(name = "entree", nullable = false)
    private Double entree = 0.0;

    @ColumnDefault("0")
    @Column(name = "sortie", nullable = false)
    private Double sortie = 0.0;

    @Column(name = "d_prix_unitaire", nullable = false)
    private Double dPrixUnitaire;

    @ColumnDefault("now()")
    @Column(name = "date")
    private LocalDate date;

    public MvtStock() {

    }

    public MvtStock(Produit produit, Double entree, Double sortie) {
        setProduit(produit);
        setEntree(entree);
        setSortie(sortie);
        setDate(LocalDate.now());
    }

//    public MvtStock(Produit produit, Double entree, Double Sortie) {
//        setProduit(produit);
//        setEntree(entree);
//        setSortie(sortie);
//        setDate(LocalDate.now());
//    }

    public static MvtStock entreeStock(Produit produit, Double qte) {
        MvtStock mvtStock = new MvtStock(produit, qte, 0.00);
        mvtStock.setDPrixUnitaire(produit.getPrixAchat());
        return mvtStock;
    }

    public static MvtStock sortieStock(Produit produit, Double qte) throws Exception {
        Double resteEnStock = produit.getStock().getQuantite();

//        if(resteEnStock < qte) {
//            throw new Exception("Stock insuffisant pour le produit: " + produit.getNom());
//        }

        MvtStock mvtStock = new MvtStock(produit, 0.00, qte);
        mvtStock.setDPrixUnitaire(produit.getPrixVente());
        return mvtStock;
    }

}