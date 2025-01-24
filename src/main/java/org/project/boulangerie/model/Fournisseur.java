package org.project.boulangerie.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "fournisseur")
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fournisseur_id_gen")
    @SequenceGenerator(name = "fournisseur_id_gen", sequenceName = "fournisseur_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @ColumnDefault("now()")
    @Column(name = "date_creation", nullable = false)
    private LocalDate dateCreation = LocalDate.now();

}