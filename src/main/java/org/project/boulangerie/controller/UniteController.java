package org.project.boulangerie.controller;

import annotations.spring.ControllerProps;
import org.project.boulangerie.model.Unite;
import org.project.boulangerie.service.UniteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.nx.CrudController;
import spring.nx.NxService;

@Controller
@RequestMapping("/unite")
@ControllerProps(viewsDirectory = "nx", layout = "layout")
public class UniteController extends CrudController<Unite, Integer> {
    private final UniteService uniteService;

    public UniteController(UniteService service) {
        super(service);
        this.uniteService = service;

    }
}
