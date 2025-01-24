package org.project.boulangerie.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nom", length = 20)
    private String nom;

    @Override
    public String toString() {
        return nom;
    }
}