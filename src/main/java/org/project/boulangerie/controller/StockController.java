package org.project.boulangerie.controller;

import org.project.boulangerie.model.Stock;
import org.project.boulangerie.service.StockService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import spring.nx.NxController;
import spring.nx.NxService;

@Controller
@RequestMapping("/stock")
public class StockController extends NxController<Stock, Integer> {
    private final StockService stockService;

    public StockController(StockService service) {
        super(service);
        this.stockService = service;
    }

    @GetMapping("/list")
    public ModelAndView showList(@RequestParam MultiValueMap<String, Object> params) {
//        stockService.findAllPageable(PageRequest.of(0, 50), new LinkedMultiValueMap<>()).forEach(stock -> {
//            System.out.println(String.format("ID: %s, ID_PRODUIT: %s, NOM_PRODUIT: %s, QTE: %s", stock.getId(), stock.getProduit().getId(), stock.getQuantite()));
//        });

        System.out.println("======================================");
//        stockService.findAll().forEach(stock -> {
//            System.out.println(String.format("ID: %s, ID_PRODUIT: %s, QTE: %s", stock.getId(), stock.getIdProduit(), stock.getQuantite()));
//        });

        ModelAndView modelAndView = getModelAndView("nx/list-read");
        this.generateDataTable(modelAndView, params);
        modelAndView.addObject("showCols", "nomProduit,quantite,prixAchat,prixVente");
        return modelAndView;
    }
}
