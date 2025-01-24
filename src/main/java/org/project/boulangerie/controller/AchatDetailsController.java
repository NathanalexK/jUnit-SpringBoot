package org.project.boulangerie.controller;

import org.project.boulangerie.model.AchatDetails;
import org.project.boulangerie.service.AchatDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import spring.nx.NxController;
import spring.nx.NxService;

@Controller
@RequestMapping("/achat")
public class AchatDetailsController extends NxController<AchatDetails, Integer> {
    public AchatDetailsController(AchatDetailsService service) {
        super(service);
    }

    @GetMapping("/list")
    public ModelAndView showList(@RequestParam MultiValueMap params){
        ModelAndView mav = this.getModelAndView("achat/list");
        this.generateDataTable(mav, params);
        mav.addObject("showCols", "ingredient,quantite,dPrixUnitaire,tDateAchat");
        return mav;
    }
}
