package org.project.boulangerie.model;

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
@Table(name = "achat")
public class Achat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('achat_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @ColumnDefault("now()")
    @Column(name = "date_heure", nullable = false)
    private LocalDate dateHeure;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_fournisseur")
    private Fournisseur fournisseur;

    @Column(name = "d_prix_total")
    private Double dPrixTotal;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "achatMere")
    private List<AchatDetails> achatDetailsList;


//    public Double getDPrixTotal() {
//        Double sum = 0.00;
//        if(achatDetailsList != null) return null;
//
//        for(AchatDetails achatDetails: achatDetailsList) {
//            sum += achatDetails.getDPrixUnitaire() * achatDetails.getQuantite();
//        }
//
//        return sum;
//    }

    public List<MvtStock> genererEntreeStock() {
        List<MvtStock> mvtStockList = new ArrayList<>();
        this.getAchatDetailsList().forEach(achatDetails -> {
            mvtStockList.add(achatDetails.genererEntreeStock());
        });
        return mvtStockList;
    }

}