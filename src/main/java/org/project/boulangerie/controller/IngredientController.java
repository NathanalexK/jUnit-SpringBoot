package org.project.boulangerie.controller;

import components.forms.ValueLabel;
import components.forms.form.FormData;
import org.project.boulangerie.component.SessionManager;
import org.project.boulangerie.form.IngredientForm;
import org.project.boulangerie.model.Ingredient;
import org.project.boulangerie.model.Produit;
import org.project.boulangerie.repository.IngredientRepository;
import org.project.boulangerie.service.IngredientService;
import org.project.boulangerie.service.TypeProduitService;
import org.project.boulangerie.service.UniteService;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.nx.NxController;
import spring.nx.NxService;

@Controller
@RequestMapping("/ingredient")
public class IngredientController extends NxController<Ingredient, Integer> {
    private final IngredientService ingredientService;
    private final TypeProduitService typeProduitService;
    private final SessionManager sessionManager;
    private final UniteService uniteService;

    public IngredientController(IngredientService service,
                                TypeProduitService typeProduitService, SessionManager sessionManager, UniteService uniteService) {
        super(service);
        this.ingredientService = service;
        this.typeProduitService = typeProduitService;
        this.sessionManager = sessionManager;
        this.uniteService = uniteService;
    }

    @GetMapping("/form")
    public ModelAndView showForm(@RequestParam(name = "id", required = false) Ingredient ingredient) {
        ModelAndView modelAndView = getModelAndView("ingredient/form");
        FormData formData = new FormData();
        formData.setMethod("POST");
        formData.setAction("/ingredient/save");
        formData.addData("unite", uniteService.findAll().stream().map(item -> new ValueLabel(item, item.getId(), item.getNom() + " (" + item.getCode() + ")")).toList());
        this.generateForm(modelAndView, new IngredientForm(ingredient), formData);
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView showList(@RequestParam MultiValueMap params) {
        ModelAndView modelAndView = getModelAndView("ingredient/list");
        this.generateDataTable(modelAndView, params);
        modelAndView.addObject("showCols", "nomIngredient,uniteLib,prixAchat");
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(
        @ModelAttribute IngredientForm ingredientForm
    ) {
        ingredientService.save(ingredientForm);
        sessionManager.addSuccessAlert("Ingredient ajouté avec succès!");
        return redirect("/ingredient/list");
    }
}
