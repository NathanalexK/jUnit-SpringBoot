package org.project.boulangerie.model;

//import annotations.forms.FormRepeat;
import annotations.forms.Input;
import annotations.forms.Select;
import annotations.forms.SkipInput;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.project.boulangerie.dto.RecetteDTO;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "produit_fini")
public class ProduitFini {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('produit_fini_id_seq')")
    @Column(name = "id", nullable = false)
    @Input(type =  "hidden")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_produit", nullable = false)
    @SkipInput
    private Produit produit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categorie")
    @Select
    private CategorieProduit categorie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_parfum")
    private Parfum parfum;


    @OneToMany(mappedBy = "produitFini", cascade = CascadeType.ALL)
    private List<Recette> recettes;

    @Transient
    @Input(type = "text")
    private String nom;

    @Transient
    @Input(type = "number", step = "0.01")
    private Double prixVente;

    public MvtStock genererEntreeMvtStock(Double qte) {
        MvtStock mvtStock = this.getProduit().genererEntreeStock(qte);
        mvtStock.setDPrixUnitaire(this.getPrixVente());
        return mvtStock;
    }

    public MvtStock genererSortieMvtStock(Double qte) throws Exception {
        MvtStock mvtStock = this.getProduit().genererSortieStock(qte);
        mvtStock.setDPrixUnitaire(this.getPrixVente());
        return mvtStock;
    }


    public Double getPrixVente() {
        if(this.getProduit() != null) {
            return this.getProduit().getPrixVente();
        }
        return prixVente;
    }

    public String getNom() {
        if(this.getProduit() != null) {
            return this.getProduit().getNom();
        }
        return nom;
    }

    public List<RecetteDTO> getRecettesDTO() {
        List<RecetteDTO> recetteDTOS = new ArrayList<>();
        for(Recette recette: this.getRecettes()) {
            RecetteDTO recetteDTO = new RecetteDTO();
            recetteDTO.setNom(recette.getIngredient().getNomIngredient());
            recetteDTO.setQte(recette.getQuantite());
            recetteDTO.setUnite(recette.getIngredient().getUniteLib());
            recetteDTO.setStock(recette.getIngredient().getProduit().getStock().getQuantite());
            recetteDTOS.add(recetteDTO);
        }
        return recetteDTOS;
    }

    @Override
    public String toString() {
        return this.getNom();
    }
}