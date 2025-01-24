package org.project.boulangerie.controller;

import org.project.boulangerie.model.CategorieProduit;
import org.project.boulangerie.service.CategorieProduitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.nx.CrudController;
import spring.nx.NxService;

@Controller
@RequestMapping("/categorie-produit")
public class CategorieProduitController extends CrudController<CategorieProduit, Integer> {

    public CategorieProduitController(CategorieProduitService service) {
        super(service);
    }
}
