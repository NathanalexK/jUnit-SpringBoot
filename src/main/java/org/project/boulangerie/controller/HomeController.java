package org.project.boulangerie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import spring.nx.NxController;
import spring.nx.NxService;

@Controller
@RequestMapping("/")
public class HomeController extends NxController {
    public HomeController() {
        super(null);
    }

    @GetMapping
    public ModelAndView index() {
        return getModelAndView("home");
    }


}
