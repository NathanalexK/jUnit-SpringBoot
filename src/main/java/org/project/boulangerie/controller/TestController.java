package org.project.boulangerie.controller;

import org.project.boulangerie.dto.CommissionVendeurDTO;
import org.project.boulangerie.service.VendeurService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController{

    private final VendeurService vendeurService;

    public TestController(VendeurService vendeurService) {
        this.vendeurService = vendeurService;
    }

    @GetMapping("/exception")
    public void testExceptionHandler() throws Exception {
        throw new Exception("An error occured");
    }

    @GetMapping("/commissions")
    public ModelAndView showComissions(@RequestParam(name = "debut", required = false) LocalDate debut, @RequestParam(name = "fin", required = false) LocalDate fin) throws Exception {
        ModelAndView mav = new ModelAndView("layout");
        mav.addObject("content", "/nx/vendeur/commissions");
        List<CommissionVendeurDTO> commissions = vendeurService.getCommissionsParVendeur(debut, fin);
        System.out.println("debut " + debut);
        mav.addObject("model", commissions);
        return mav;
    }
}
