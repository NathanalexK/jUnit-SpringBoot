package org.project.boulangerie.service;

import jakarta.transaction.Transactional;
import org.project.boulangerie.form.RecommendationForm;
import org.project.boulangerie.model.Recommendation;
import org.project.boulangerie.repository.RecommendationRepository;
import org.springframework.stereotype.Service;
import spring.nx.NxService;

@Service
public class RecommendationService extends NxService<Recommendation, Integer> {

	private final RecommendationRepository recommendationRepository;

	public RecommendationService(RecommendationRepository repository) {
		super(repository);
		this.recommendationRepository = repository;
	}

	@Transactional
	public Recommendation save(RecommendationForm form) throws Exception {
		Recommendation recommendation = new Recommendation();

		if(recommendationRepository.isRecommendationAlreadyExist(form.getProduitFini().getId(), form.getMois(), form.getAnnee())){
			throw new Exception("Produit deja recommendé pour cette mois");
		}

		recommendation.setIdProduitFini(form.getProduitFini());
		recommendation.setMois(form.getMois());
		recommendation.setAnnee(form.getAnnee());
		return recommendationRepository.save(recommendation);
	}
}