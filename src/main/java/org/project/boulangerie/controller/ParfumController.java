package org.project.boulangerie.controller;

import org.project.boulangerie.model.Parfum;
import org.project.boulangerie.service.ParfumService;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.nx.CrudController;

@Controller
@RequestMapping("/parfum")
public class ParfumController extends CrudController<Parfum, Integer> {
	private final ParfumService parfumService;

	public ParfumController(ParfumService service) {
		super(service);
		this.parfumService = service;
	}

}