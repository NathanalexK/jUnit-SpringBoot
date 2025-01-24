package org.project.boulangerie.controller;

import components.forms.ValueLabel;
import components.forms.form.FormData;
import org.project.boulangerie.component.SessionManager;
import org.project.boulangerie.model.Production;
import org.project.boulangerie.service.CategorieProduitService;
import org.project.boulangerie.service.IngredientService;
import org.project.boulangerie.service.ProductionService;
import org.project.boulangerie.service.ProduitFiniService;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.nx.NxController;
import spring.nx.NxService;

@Controller
@RequestMapping("/production")
public class ProductionController extends NxController<Production, Integer> {
    private final ProduitFiniService produitFiniService;
    private final ProductionService productionService;
    private final SessionManager sessionManager;
    private final IngredientService ingredientService;
    private final CategorieProduitService categorieProduitService;

    public ProductionController(ProductionService service, ProduitFiniService produitFiniService, SessionManager sessionManager, IngredientService ingredientService, CategorieProduitService categorieProduitService) {
        super(service);
        this.produitFiniService = produitFiniService;
        this.productionService = service;
        this.sessionManager = sessionManager;
        this.ingredientService = ingredientService;
        this.categorieProduitService = categorieProduitService;
    }

    @GetMapping("/form")
    public ModelAndView showForm(@RequestParam(name = "id", required = false) Production production) {
        ModelAndView mav = this.getModelAndView("production/form");
        FormData formData = new FormData();
        formData.setMethod("POST");
        formData.setAction("/production/save");
        formData.addData("produitFini", produitFiniService.findAll().stream().map(pf -> new ValueLabel(pf, pf.getId(), pf.getProduit().getNom())).toList(), true);
        this.generateForm(mav, production, formData);
        return mav;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Production production) throws Exception {
        productionService.save(production);
        sessionManager.addSuccessAlert("Production ajouté avec succès");
        return redirect("");
    }

    @GetMapping("/list")
    public ModelAndView list(@RequestParam MultiValueMap<String, Object> params) {
        ModelAndView mav = this.getModelAndView("production/list");
        this.generateDataTable(mav, params);
        mav.addObject("ingredientsVL", ingredientService.findAll().stream().map(item -> new ValueLabel(item.getId(), item.getId(), item.getNomIngredient())).toList());
        mav.addObject("produitsFiniVL", produitFiniService.findAll().stream().map(item -> new ValueLabel(item.getId(), item.getId(), item.getNom())).toList());
        mav.addObject("showCols", "productionLib,qte,dPrixUnitaire,dateProduction");
        return mav;
    }
}
