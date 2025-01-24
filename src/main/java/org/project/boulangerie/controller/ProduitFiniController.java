package org.project.boulangerie.controller;

import components.forms.ValueLabel;
import components.forms.form.FormData;
import org.project.boulangerie.component.SessionManager;
import org.project.boulangerie.form.ProduitFiniForm;
import org.project.boulangerie.model.ProduitFini;
import org.project.boulangerie.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.nx.NxController;
import spring.nx.NxService;

@Controller
@RequestMapping("/produit-fini")
public class ProduitFiniController extends NxController<ProduitFini, Integer> {
    private final ProduitFiniService produitFiniService;
    private final CategorieProduitService categorieProduitService;
    private final IngredientService ingredientService;
    private final UniteService uniteService;
    private final SessionManager sessionManager;
    private final ParfumService parfumService;

    public ProduitFiniController(ProduitFiniService service, CategorieProduitService categorieProduitService, IngredientService ingredientService, UniteService uniteService, SessionManager sessionManager, ParfumService parfumService) {
        super(service);
        this.produitFiniService = service;
        this.categorieProduitService = categorieProduitService;
        this.ingredientService = ingredientService;
        this.uniteService = uniteService;
        this.sessionManager = sessionManager;
        this.parfumService = parfumService;
    }

    @GetMapping("/list")
    public ModelAndView showList(
        @RequestParam MultiValueMap<String, Object> params
    ) {
        ModelAndView modelAndView = this.getModelAndView("produit-fini/list");
        this.generateDataTable(modelAndView, params);
        modelAndView.addObject("showCols", "nom,categorie,prixVente");
        modelAndView.addObject("ingredientsVL", ingredientService.findAll().stream().map(item -> new ValueLabel(item.getId(), item.getId(), item.getNomIngredient())).toList());
        modelAndView.addObject("categoriesVL", categorieProduitService.findAll().stream().map(item -> new ValueLabel(item.getId(), item.getId(), item.getNom())).toList());

        return modelAndView;
    }

    @GetMapping("/form")
    public ModelAndView showForm(
        @RequestParam(name = "id", required = false) ProduitFini produitFini
    ) {
        ModelAndView modelAndView = getModelAndView("produit-fini/form");
        FormData formData = new FormData();
        formData.setAction("/produit-fini/save");
        formData.setMethod("POST");
        formData.addData("categorieProduit", categorieProduitService.findAll().stream().map(item -> new ValueLabel(item, item.getId(), item.getNom())).toList());
        formData.addData("parfum", parfumService.findAll().stream().map(p -> new ValueLabel(p, p.getId(), p.getNom())).toList());
        formData.addData("unite", uniteService.findAll().stream().map(item -> new ValueLabel(item, item.getId(), item.getNom() + " (" + item.getCode() + ")")).toList());
        formData.addChildData("ingredient", ingredientService.findAll().stream().map(item -> new ValueLabel(item, item.getId(), item.getNomIngredient() + " (en " + item.getProduit().getUnite().getCode() + ")")).toList());
        this.generateForm(modelAndView, new ProduitFiniForm(produitFini), formData);
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(
        @ModelAttribute ProduitFiniForm produitFiniForm
    ) throws Exception {
        produitFiniService.save(produitFiniForm);
        sessionManager.addSuccessAlert("Produit Fini inséré avec succès");
        return redirect("/produit-fini/list");
    }

    @GetMapping("/details")
    public ModelAndView showDetails(
        @RequestParam("id") ProduitFini produitFini
    ) {
        ModelAndView modelAndView = getModelAndView("produit-fini/details");
        modelAndView.addObject("produitFini", produitFini);
        return modelAndView;
    }
}
