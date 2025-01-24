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
@Table(name = "vente")
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('vente_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @ColumnDefault("now()")
    @Column(name = "date_heure", nullable = false)
    private LocalDate dateHeure;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vendeur")
    private Vendeur vendeur;

    @Column(name = "commission")
    private Double commission;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vente", cascade = CascadeType.ALL)
    private List<VenteDetail> venteDetailList;



    public List<MvtStock> genererSortieStock() throws Exception {
        List<MvtStock> mvtStockList = new ArrayList<>();

        for(VenteDetail venteDetail: venteDetailList) {
            mvtStockList.add(venteDetail.genererSortieStock());
        }

        return mvtStockList;
    }
}