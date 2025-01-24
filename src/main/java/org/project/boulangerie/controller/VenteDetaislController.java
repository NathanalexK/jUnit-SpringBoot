package org.project.boulangerie.controller;

import components.forms.ValueLabel;
import org.project.boulangerie.model.VenteDetail;
import org.project.boulangerie.service.CategorieProduitService;
import org.project.boulangerie.service.ParfumService;
import org.project.boulangerie.service.VenteDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import spring.nx.NxController;
import spring.nx.NxService;

@Controller
@RequestMapping("/vente")
public class VenteDetaislController extends NxController<VenteDetail, Integer> {
    private final CategorieProduitService categorieProduitService;
    private final ParfumService parfumService;

    public VenteDetaislController(VenteDetailsService service, CategorieProduitService categorieProduitService, ParfumService parfumService) {
        super(service);
        this.categorieProduitService = categorieProduitService;
        this.parfumService = parfumService;
    }

    @GetMapping("/list")
    public ModelAndView showList(@RequestParam MultiValueMap<String, Object> params) {
        ModelAndView mav = this.getModelAndView("vente/list");
        this.generateDataTable(mav, params);
        mav.addObject("showCols", "produitFini,quantite,nomClient,tDateVente");
        mav.addObject("categories", categorieProduitService.findAll().stream().map(c -> new ValueLabel(c.getId(), c.getId(), c.getNom())).toList());
        mav.addObject("parfums", parfumService.findAll().stream().map(p -> new ValueLabel(p.getId(), p.getId(), p.getNom())).toList());
        return mav;
    }


}
