package org.project.boulangerie.controller;

import org.project.boulangerie.model.TypeProduit;
import org.project.boulangerie.service.TypeProduitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.nx.CrudController;

@Controller
@RequestMapping("/type-produit")
public class TypeProduitController extends CrudController<TypeProduit, Integer> {


    public TypeProduitController(TypeProduitService service) {
        super(service);
    }
}
