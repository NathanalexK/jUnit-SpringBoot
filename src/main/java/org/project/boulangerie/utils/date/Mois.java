package org.project.boulangerie.utils.date;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Mois {
    private Integer id;
    private String nom;

    public Mois(Integer id, String nom) {
        this.setId(id);
        this.setNom(nom);
    }

    public static List<Mois> genererListeMois() {
        List<Mois> listeMois = new ArrayList<>();

        listeMois.add(new Mois(1, "Janvier"));
        listeMois.add(new Mois(2, "Février"));
        listeMois.add(new Mois(3, "Mars"));
        listeMois.add(new Mois(4, "Avril"));
        listeMois.add(new Mois(5, "Mai"));
        listeMois.add(new Mois(6, "Juin"));
        listeMois.add(new Mois(7, "Juillet"));
        listeMois.add(new Mois(8, "Août"));
        listeMois.add(new Mois(9, "Septembre"));
        listeMois.add(new Mois(10, "Octobre"));
        listeMois.add(new Mois(11, "Novembre"));
        listeMois.add(new Mois(12, "Décembre"));

        return listeMois;
    }
}
