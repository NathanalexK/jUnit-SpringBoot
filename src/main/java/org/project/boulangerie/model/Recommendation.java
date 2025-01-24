package org.project.boulangerie.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.project.boulangerie.utils.date.Mois;

@Getter
@Setter
@Entity
@Table(name = "recommendation_produit")
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recommendation_produit_id_gen")
    @SequenceGenerator(name = "recommendation_produit_id_gen", sequenceName = "recommendation_produit_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produit_fini")
    private ProduitFini idProduitFini;

    @Transient
    private String tMois;

    @Column(name = "mois")
    private Integer mois;

    @Column(name = "annee")
    private Integer annee;

    @Transient
    private String categorieLib;

    @Transient
    private String parfumLib;

    public String getCategorieLib() {
        return this.getIdProduitFini().getCategorie().getNom();
    }

    public String getParfumLib() {
        return this.getIdProduitFini().getParfum().getNom();
    }

    public String getTMois(){
        return Mois.genererListeMois().get(mois - 1).getNom();
    }
}