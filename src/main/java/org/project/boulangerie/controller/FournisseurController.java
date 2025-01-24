package org.project.boulangerie.controller;

import org.project.boulangerie.model.Fournisseur;
import org.project.boulangerie.service.FournisseurService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.nx.CrudController;
import spring.nx.NxService;

@Controller
@RequestMapping("/fournisseur")
public class FournisseurController extends CrudController<Fournisseur, Integer> {
    public FournisseurController(FournisseurService service) {
        super(service);
    }
}
