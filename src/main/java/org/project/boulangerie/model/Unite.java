package org.project.boulangerie.model;

import annotations.forms.Input;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "unite")
public class Unite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('unite_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "code", nullable = false, length = 10)
    @Input(placeholder = "KG")
    private String code;

    @Input(placeholder = "Kilogramme")
    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    @Override
    public String toString() {
        return nom;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Unite unite = (Unite) object;
        return Objects.equals(id, unite.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}