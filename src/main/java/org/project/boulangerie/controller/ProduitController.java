package org.project.boulangerie.controller;

import components.forms.ValueLabel;
import components.forms.form.FormData;
import org.project.boulangerie.model.Produit;
import org.project.boulangerie.service.ProduitService;
import org.project.boulangerie.service.TypeProduitService;
import org.project.boulangerie.service.UniteService;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import spring.nx.NxController;


@Controller
@RequestMapping("/produit")
public class ProduitController extends NxController<Produit, Integer> {
    private final ProduitService produitService;
    private final TypeProduitService typeProduitService;
    private final UniteService uniteService;

    public ProduitController(ProduitService service, TypeProduitService typeProduitService, UniteService uniteService) {
        super(service);
        this.produitService = service;
        this.typeProduitService = typeProduitService;
        this.uniteService = uniteService;
    }

    @GetMapping("/list")
    public ModelAndView showList(
        @RequestParam MultiValueMap<String, Object> params
    ) {
        ModelAndView modelAndView = getModelAndView("produit/list");
        this.generateDataTable(modelAndView, params);
        modelAndView.addObject("uniteVL", uniteService.getValueLabel(u -> new ValueLabel(u.getId(), u.getId(), u.getNom() + " (" + u.getCode() + ")")));
//        modelAndView.addObject("showCols", "nom");
        return modelAndView;
    }



    @GetMapping("/form")
    public ModelAndView showForm(
        @RequestParam(name = "id", required = false) Produit produit
    ) {
        ModelAndView modelAndView = getModelAndView("produit/form");
        FormData formData = new FormData();
        formData.setAction("/produit/save");
        formData.addData("typeProduit", typeProduitService.findAll().stream().map(item -> new ValueLabel(item, item.getId(), item.getNom())).toList());
        this.generateForm(modelAndView, produit, formData);
        modelAndView.addObject("typeProduit", produitService.findAll());
        return modelAndView;
    }


}
