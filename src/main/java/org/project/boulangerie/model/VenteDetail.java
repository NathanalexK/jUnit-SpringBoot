package org.project.boulangerie.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "vente_details")
public class VenteDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('vente_details_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_vente", nullable = false)
    private Vente vente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_produit_fini", nullable = false)
    private ProduitFini produitFini;

    @Column(name = "quantie", nullable = false)
    private Double quantite;

    @Column(name = "d_prix_unitaire", nullable = false)
    private Double dPrixUnitaire;

    @Transient
    private LocalDate tDateVente;

    @Transient
    private String nomClient;

    public Double getDPrixUnitaire() {
        if(dPrixUnitaire != null) return dPrixUnitaire;

        if(produitFini != null) {
            setDPrixUnitaire(produitFini.getPrixVente());
        }

        
        return dPrixUnitaire;
    }

    public MvtStock genererSortieStock() throws Exception {
        MvtStock mvtStock = this.getProduitFini().getProduit().genererSortieStock(this.getQuantite());
        return mvtStock;
    }

    public LocalDate getTDateVente() {
        if(tDateVente != null) return tDateVente;

        if(this.getVente() != null) {
            this.setTDateVente(this.getVente().getDateHeure());
        }

        return tDateVente;
    }

    public String getNomClient() {
        if(this.getVente().getClient()== null) return "Client Divers";
        return this.getVente().getClient().getNom();
    }
}