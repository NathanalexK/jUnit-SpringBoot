package org.project.boulangerie.model;

import annotations.forms.Select;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vendeur")
public class Vendeur {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendeur_id_gen")
    @SequenceGenerator(name = "vendeur_id_gen", sequenceName = "vendeur_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nom", length = 50)
    private String nom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_genre")
    @Select
    private Genre genre;
}