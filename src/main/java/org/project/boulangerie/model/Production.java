package org.project.boulangerie.model;

import annotations.forms.Hidden;
import annotations.forms.Input;
import annotations.forms.Select;
import annotations.forms.SkipInput;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "production")
public class Production {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('production_id_seq')")
    @Column(name = "id", nullable = false)
    @Hidden
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_produit_fini", nullable = false)
    @Select
    private ProduitFini produitFini;

    @Column(name = "qte")
    private Double qte;

    @Column(name = "d_prix_unitaire")
    @SkipInput
    private Double dPrixUnitaire;

    @ColumnDefault("now()")
    @Column(name = "date_production")
    @Input(append = "disabled")
    private LocalDate dateProduction = LocalDate.now();

    @Transient
    @SkipInput
    private String productionLib;

//    @Transient
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "")
//    private List<Recette> recettes = new ArrayList<>();

    public List<MvtStock> genererMvtSock() throws Exception {
        List<MvtStock> mvtStocks = new ArrayList<>();
        MvtStock entreeStock = this.getProduitFini().genererEntreeMvtStock(this.getQte());
//        MvtStock entreeStock = MvtStock.entreeStock(produitFini.getProduit(), this.getDPrixUnitaire());
//        produitFini.ge

        for(Recette recette: this.getProduitFini().getRecettes()){
//            MvtStock sortieStock = MvtStock.sortieStock(recette.getIngredient().getProduit(), recette.getQuantite());
            MvtStock sortieStock = recette.getIngredient().genererSortieMvtStock(recette.getQuantite() * this.getQte());
            mvtStocks.add(sortieStock);
        }

        mvtStocks.add(entreeStock);
        return mvtStocks;
    }



    public Double getDPrixUnitaire() {
        if(this.dPrixUnitaire == null && this.getProduitFini() != null) {
            this.setDPrixUnitaire(this.getProduitFini().getPrixVente());
        }
        return dPrixUnitaire;
    }

    public String getProductionLib() {
        return this.getProduitFini().getNom();

    }

//    public List<Recette> getRecettes() {
//        return recettes;
//    }
}