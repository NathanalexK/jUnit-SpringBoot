package org.project.boulangerie.model;

import annotations.forms.Hidden;
import annotations.forms.Input;
import annotations.forms.Select;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('produit_id_seq')")
    @Column(name = "id", nullable = false)
    @Hidden
    private Integer id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_type_produit", nullable = false)
    @Select
    private TypeProduit typeProduit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unite", nullable = false)
    private Unite unite;

    @Column(name = "prix_achat")
    @Input(type = "number", step = "0.01")
    private Double prixAchat;

    @Column(name = "prix_vente")
    @Input(type = "number", step = "0.01")
    private Double prixVente;

//    @Transient
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "produit", targetEntity = Stock.class)
    private Stock stock;

    public MvtStock genererEntreeStock(Double qte) {
        MvtStock mvtStock = MvtStock.entreeStock(this, qte);
        return mvtStock;
    }

    public MvtStock genererSortieStock(Double qte) throws Exception {
        MvtStock mvtStock = MvtStock.sortieStock(this, qte);
        return mvtStock;
    }

//    @OneToOne()



}