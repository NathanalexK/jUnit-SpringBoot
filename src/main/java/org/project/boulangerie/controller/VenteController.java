package org.project.boulangerie.controller;

import components.forms.ValueLabel;
import components.forms.form.FormData;
import org.project.boulangerie.component.SessionManager;
import org.project.boulangerie.dto.CommissionVendeurDTO;
import org.project.boulangerie.form.AchatForm;
import org.project.boulangerie.form.VenteForm;
import org.project.boulangerie.model.Achat;
import org.project.boulangerie.model.Vente;
import org.project.boulangerie.service.ClientService;
import org.project.boulangerie.service.ProduitFiniService;
import org.project.boulangerie.service.VendeurService;
import org.project.boulangerie.service.VenteService;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.nx.NxController;
import spring.nx.NxService;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/vente")
public class VenteController extends NxController<Vente, Integer> {

    private final ClientService clientService;
    private final ProduitFiniService produitFiniService;
    private final VenteService venteService;
    private final SessionManager sessionManager;
    private final VendeurService vendeurService;

    public VenteController(NxService<Vente, Integer> service, ClientService clientService, ProduitFiniService produitFiniService, VenteService venteService, SessionManager sessionManager, VendeurService vendeurService) {
        super(service);
        this.clientService = clientService;
        this.produitFiniService = produitFiniService;
        this.venteService = venteService;
        this.sessionManager = sessionManager;
        this.vendeurService = vendeurService;
    }

    @GetMapping("/form")
    public ModelAndView showForm(@RequestParam(name = "id", required = false) Vente vente) {
        ModelAndView mav = this.getModelAndView("vente/form");
        FormData formData = new FormData();
        formData.setAction("/vente/save");
        formData.setMethod("POST");
        formData.addData("vendeur", vendeurService.getValueLabel(v -> new ValueLabel(v, v.getId(), v.getNom())));
        formData.addData("client", clientService.findAll().stream().map(client -> new ValueLabel(client, client.getId(), client.getNom())).toList(), true);
        formData.addChildData("produitFini", produitFiniService.findAll().stream().map(pf -> new ValueLabel(pf, pf.getId(), pf.getNom())).toList());
        this.generateForm(mav, new VenteForm(), formData);
        return mav;
    }

//    @GetMapping("/list")
//    public ModelAndView showList(@RequestParam MultiValueMap<String, Object> params) {
//        ModelAndView mav = this.getModelAndView("vente/list");
//        this.generateDataTable(mav, params);
//        return mav;
//    }

    @PostMapping("/save")
    public String save(@ModelAttribute VenteForm venteForm) throws Exception {
        venteService.save(venteForm);
        sessionManager.addSuccessAlert("Achat effectué avec succès");
        return redirect("/vente/list");
    }


    @GetMapping("/client")
    public ModelAndView showClient(@RequestParam(name = "date", required = false) LocalDate date) {
        ModelAndView mav = this.getModelAndView("vente/client");
        mav.addObject("model", venteService.getVenteByDate(date));
//        clientService.

        return mav;

    }

    @GetMapping("/commissions")
    public ModelAndView showComissions(@RequestParam(name = "debut_eq", required = false)LocalDate debut, @RequestParam(name = "fin_eq", required = false) LocalDate fin) throws Exception {
        ModelAndView mav = this.getModelAndView("vendeur/commission");
        List<CommissionVendeurDTO> commissions = vendeurService.getCommissionsParVendeur(debut, fin);
        System.out.println("debut " + debut);
        mav.addObject("model", commissions);
        return mav;
    }



}
