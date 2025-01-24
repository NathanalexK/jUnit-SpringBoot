package org.project.boulangerie.model;

import annotations.forms.Input;
import annotations.forms.Select;
import annotations.forms.SkipInput;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "recette")
public class Recette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('recette_id_seq')")
    @Column(name = "id", nullable = false)
    @Input(type = "hidden")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_produit_fini", nullable = false)
    @SkipInput
    private ProduitFini produitFini;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ingredient")
    @Select
    private Ingredient ingredient;

    @Column(name = "quantite", nullable = false)
    @Input(type = "number", step = "0.01")
    private Double quantite;

    @Transient
    @SkipInput
//    @Input(type = "hidden")

    private Integer idProduitFini;

    public Integer getIdProduitFini() {
        return this.getProduitFini().getId();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Recette recette = (Recette) object;
        return Objects.equals(id, recette.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}