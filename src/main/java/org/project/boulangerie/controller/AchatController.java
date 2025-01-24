package org.project.boulangerie.controller;

import components.forms.ValueLabel;
import components.forms.form.FormData;
import org.project.boulangerie.component.SessionManager;
import org.project.boulangerie.form.AchatForm;
import org.project.boulangerie.model.Achat;
import org.project.boulangerie.service.AchatService;
import org.project.boulangerie.service.FournisseurService;
import org.project.boulangerie.service.IngredientService;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.nx.NxController;
import spring.nx.NxService;

@Controller
@RequestMapping("/achat")
public class AchatController extends NxController<Achat, Integer> {
    private final FournisseurService fournisseurService;
    private final IngredientService ingredientService;
    private final AchatService achatService;
    private final SessionManager sessionManager;

    public AchatController(AchatService service, FournisseurService fournisseurService, IngredientService ingredientService, AchatService achatService, SessionManager sessionManager) {
        super(service);
        this.fournisseurService = fournisseurService;
        this.ingredientService = ingredientService;
        this.achatService = achatService;
        this.sessionManager = sessionManager;
    }

    @GetMapping("/form")
    public ModelAndView showForm(@RequestParam(name = "id", required = false) Achat achat) {
        ModelAndView mav = this.getModelAndView("achat/form");
        FormData formData = new FormData();
        formData.setAction("/achat/save");
        formData.setMethod("POST");
        formData.addData("fournisseur", fournisseurService.findAll().stream().map(fournisseur -> new ValueLabel(fournisseur, fournisseur.getId(), fournisseur.getNom())).toList(), true);
        formData.addChildData("ingredient", ingredientService.getValueLabel(ingredient -> new ValueLabel(ingredient, ingredient.getId(), ingredient.getNomIngredient(), "data-prix=\"" + ingredient.getPrixAchat() + "\"")), true);
        this.generateForm(mav, new AchatForm(), formData);
        return mav;
    }

//    @GetMapping("/list")
    public ModelAndView showList(@RequestParam MultiValueMap<String, Object> params) {
        ModelAndView mav = this.getModelAndView("achat/list");
        this.generateDataTable(mav, params);
        return mav;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute AchatForm achatForm) {
        achatService.save(achatForm);
        sessionManager.addSuccessAlert("Achat effectué avec succès");
        return redirect("/achat/list");
    }
}
