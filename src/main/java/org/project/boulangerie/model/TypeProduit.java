package org.project.boulangerie.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "type_produit")
public class TypeProduit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('type_produit_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Override
    public String toString() {
        return nom;
    }
}