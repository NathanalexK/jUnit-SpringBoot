package org.project.boulangerie.controller;

import components.forms.ValueLabel;
import components.forms.form.FormData;
import org.project.boulangerie.component.SessionManager;
import org.project.boulangerie.form.RecommendationForm;
import org.project.boulangerie.model.Recommendation;
import org.project.boulangerie.service.ProduitFiniService;
import org.project.boulangerie.service.RecommendationService;
import org.project.boulangerie.utils.date.Mois;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.nx.NxController;

@Controller
@RequestMapping("/recommendation")
public class RecommendationController extends NxController<Recommendation, Integer> {
	private final RecommendationService recommendationService;
	private final ProduitFiniService produitFiniService;
	private final SessionManager sessionManager;

	public RecommendationController(RecommendationService service, ProduitFiniService produitFiniService, SessionManager sessionManager) {
		super(service);
		this.recommendationService = service;
		this.produitFiniService = produitFiniService;
		this.sessionManager = sessionManager;
	}

	@GetMapping("/form")
	public ModelAndView showForm(@RequestParam(name = "id", required = false) Recommendation recommendation) {
		ModelAndView mav = this.getModelAndView("recommendation/form");
		FormData formData = new FormData();
		formData.setAction("/recommendation/save");
		formData.setMethod("POST");
		formData.addData("produitFini", produitFiniService.getValueLabel(pf -> new ValueLabel(pf, pf.getId(), pf.getProduit().getNom())));
		formData.addData("mois", Mois.genererListeMois().stream().map(m -> new ValueLabel(m.getId(), m.getId(), m.getNom())).toList());
		this.generateForm(mav, new RecommendationForm(), formData);
		return mav;
	}

	@PostMapping("/save")
	public String save(@ModelAttribute RecommendationForm form) throws Exception {
		recommendationService.save(form);
		sessionManager.addSuccessAlert("Recommendation inséré avec succes");
		return redirect("/recommendation/list");
	}

	@GetMapping("/list")
	public ModelAndView showList(@RequestParam MultiValueMap<String, Object> params) {
		ModelAndView mav = this.getModelAndView("recommendation/list");
		mav.addObject("moisVL",  Mois.genererListeMois().stream().map(m -> new ValueLabel(m.getId(), m.getId(), m.getNom())).toList());
		this.generateDataTable(mav, params);
		return mav;
	}



}