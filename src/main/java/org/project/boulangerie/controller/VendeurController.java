package org.project.boulangerie.controller;

import annotations.spring.ControllerProps;
import components.forms.ValueLabel;
import components.forms.form.InitForm;
import org.project.boulangerie.dto.CommissionGenreDTO;
import org.project.boulangerie.dto.CommissionVendeurDTO;
import org.project.boulangerie.dto.RecetteDTO;
import org.project.boulangerie.model.Vendeur;
import org.project.boulangerie.service.GenreService;
import org.project.boulangerie.service.VendeurService;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.nx.CrudController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/vendeur")
@ControllerProps(viewsDirectory = "vendeur", layout = "layout")
public class VendeurController extends CrudController<Vendeur, Integer> implements InitForm {
	private final VendeurService vendeurService;
	private final GenreService genreService;

	public VendeurController(VendeurService service, GenreService genreService) {
		super(service);
		this.vendeurService = service;
		this.genreService = genreService;
	}

	@GetMapping("/commissions")
	public ModelAndView showComissions(@RequestParam(name = "debut_eq", required = false)LocalDate debut, @RequestParam(name = "fin_eq", required = false) LocalDate fin) throws Exception {
		ModelAndView mav = this.getModelAndView("commission");
		List< CommissionVendeurDTO> commissions = vendeurService.getCommissionsParVendeur(debut, fin);
		System.out.println("debut " + debut);
		mav.addObject("model", commissions);
		return mav;
	}

	@GetMapping("/commissions/genre")
	public ModelAndView showComissionsParGenre(@RequestParam(name = "debut_eq", required = false)LocalDate debut, @RequestParam(name = "fin_eq", required = false) LocalDate fin) throws Exception {
		ModelAndView mav = this.getModelAndView("commission-genre");
		List<CommissionGenreDTO> commissions = vendeurService.getCommissionsParGenre(debut, fin);
		System.out.println("debut " + debut);
		mav.addObject("model", commissions);
		return mav;
	}

	@Override
	public void doInitForm(Map<String, List<ValueLabel>> map, Map<String, List<ValueLabel>> map1) {
		map.put("genre", genreService.getValueLabel(g -> new ValueLabel(g, g.getId(), g.getNom())));
	}
}