package org.project.boulangerie.controller;

import components.forms.ValueLabel;
import components.forms.form.InitForm;
import org.project.boulangerie.model.Genre;
import org.project.boulangerie.service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.nx.CrudController;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/genre")
public class GenreController extends CrudController<Genre, Integer> {
	private final GenreService genreService;

	public GenreController(GenreService service) {
		super(service);
		this.genreService = service;
	}


}