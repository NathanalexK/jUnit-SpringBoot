package org.project.boulangerie.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "parfum")
public class Parfum {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parfum_id_gen")
    @SequenceGenerator(name = "parfum_id_gen", sequenceName = "parfum_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nom", length = 50)
    private String nom;

    @Override
    public String toString() {
        return nom;
    }
}